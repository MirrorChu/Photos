/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * @author XU Boqing
 * @version 1.3.0
 */
package io.trino.plugin.bigquery;

import com.google.cloud.bigquery.storage.v1beta1.BigQueryStorageClient;
import com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsRequest;
import com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsResponse;
import com.google.cloud.bigquery.storage.v1beta1.Storage.Stream;
import com.google.cloud.bigquery.storage.v1beta1.Storage.StreamPosition;
import com.google.common.collect.ImmutableList;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class TestBigQueryReadRows
{
    /**
     * This method aims at testing if there are failures in the BigQuery-using rows
     * @param no parameter required
     * @return this is a void method
     */
    //CS304 Issue link: https://github.com/trinodb/trino/issues/7110
    @Test
    void testNoFailures()
    {
        BigQueryStorageClient client = mock(BigQueryStorageClient.class);
        ReadRowsRequest.Builder request = newRequest();

        MockResponsesBatch batch1 = new MockResponsesBatch();
        batch1.addResponse(ReadRowsResponse.newBuilder().setRowCount(10).build());
        batch1.addResponse(ReadRowsResponse.newBuilder().setRowCount(11).build());

        // so we can run multiple tests
        List<ReadRowsResponse> responses = ImmutableList.copyOf(
                new MockBigQueryReadRows(client, request, 3, ImmutableList.of(batch1))
                        .readRows());

        assertThat(responses.size()).isEqualTo(2);
        assertThat(responses.stream().mapToLong(ReadRowsResponse::getRowCount).sum()).isEqualTo(21);
    }

    /**
     * This method aims at testing if there are retry-of-single failures in the BigQuery-using rows
     * @param no parameter required
     * @return this is a void method
     */
    //CS304 Issue link: https://github.com/trinodb/trino/issues/7110
    @Test
    void testRetryOfSingleFailure()
    {
        BigQueryStorageClient client = mock(BigQueryStorageClient.class);
        ReadRowsRequest.Builder request = newRequest();

        MockResponsesBatch batch1 = new MockResponsesBatch();
        batch1.addResponse(ReadRowsResponse.newBuilder().setRowCount(10).build());
        batch1.addException(new StatusRuntimeException(Status.INTERNAL.withDescription(
                "Received unexpected EOS on DATA frame from server.")));
        MockResponsesBatch batch2 = new MockResponsesBatch();
        batch2.addResponse(ReadRowsResponse.newBuilder().setRowCount(11).build());

        List<ReadRowsResponse> responses = ImmutableList.copyOf(
                new MockBigQueryReadRows(client, request, 3, ImmutableList.of(batch1, batch2))
                        .readRows());

        assertThat(responses.size()).isEqualTo(2);
        assertThat(responses.stream().mapToLong(ReadRowsResponse::getRowCount).sum()).isEqualTo(21);
    }

    private static ReadRowsRequest.Builder newRequest()
    {
        return ReadRowsRequest.newBuilder().setReadPosition(
                StreamPosition.newBuilder().setStream(
                        Stream.newBuilder().setName("test")));
    }

    private static final class MockBigQueryReadRows
            extends BigQueryReadRows
    {
        Iterator<MockResponsesBatch> responses;

        MockBigQueryReadRows(BigQueryStorageClient client, ReadRowsRequest.Builder request, int maxReadRowsRetries, Iterable<MockResponsesBatch> responses)
        {
            super(client, request, maxReadRowsRetries);
            this.responses = responses.iterator();
        }

        @Override
        protected Iterator<ReadRowsResponse> fetchResponses(ReadRowsRequest.Builder readRowsRequest)
        {
            return responses.next();
        }
    }
}
