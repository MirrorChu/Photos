## Progress Report

**Our group name is [Bizarre_Group](https://github.com/orgs/cs304-spring2021/teams/bizarre_group), while names and student ids of us are shown below.**

- 寇海龙 11810610
- 许博清 11812910
- 李航     11810910
- 孔祥喆 11811005
- 黄德淳 11811002



**(a) Selected Issues**

5 issues are selected in this iteration, while the number of all scheduled issues is 8. In other words, more than 50% issues are selected. Moreover, it is ensured that every one has to work on an issue.

The first selected issue is https://github.com/trinodb/trino/issues/7597, which is assigned to 寇海龙. The reason is that this issue is import for the process of casting between char and string, which is emphasized by one of the administrators of this project.

The second selected issue is https://github.com/trinodb/trino/issues/7116, which is assigned to 黄德淳. The reason is that the project already provides a relevant base class for testing, which makes it easier to construct test cases.

The third selected issue is https://github.com/trinodb/trino/issues/7113, which is assigned to 孔祥喆. The reason is that the way to construct classes in this issue is similar with the way to construct classes in the second selected issue, which means there are a little dependent to each other.

The fourth selected issue is https://github.com/trinodb/trino/issues/7110, which is assigned to 李航. The reason is that the introduction has stated the essentials to construct test cases, which makes it easier to construct.

The fifth selected issue is https://github.com/trinodb/trino/issues/7107, which is assigned to 许博清. The reason is that this issue is import for .



**(b) Test Scenarios**

For the first selected issue, the first test scenario corresponds to method **testVarcharToCharSaturatedFloorCast** in class TestCharacterStringCasts, the second test scenario corresponds to method **testVarcharToCharSaturatedFloorCast1** in class TestCharacterStringCasts.

For the second selected issue, the first test scenario corresponds to method **testShowCreateTable** in class TestRaptorBucketedConnectorTest, the second test scenario corresponds to method **testShardsSystemTableBucketNumber** in class TestRaptorBucketedConnectorTest.

For the third selected issue, the first test scenario corresponds to method **testColumnName** in class TestHiveConnectorTest, the second test scenario corresponds to method **testExplainOfCreateTableAs** in class TestHiveConnectorTest.

For the fourth selected issue, the first test scenario corresponds to method **testNoFailures** in class TestBigQueryReadRows, the second test scenario corresponds to method **testRetryOfSingleFailure** in class TestBigQueryReadRows.

For the fifth selected issue, the first test scenario corresponds to method **testRenameTable** in class TestIcebergConnectorTest, the second test scenario corresponds to method **testCreateArrayTable** in class TestIcebergConnectorTest.




**(c) Pull Requests**

The pull request for the first selected issue is https://github.com/trinodb/trino/pull/7734.

The pull request for the second selected issue is https://github.com/trinodb/trino/pull/7647.

The pull request for the third selected issue is https://github.com/trinodb/trino/pull/7714.

The pull request for the fourth selected issue is https://github.com/trinodb/trino/pull/7722.

The pull request for the fifth selected issue is https://github.com/trinodb/trino/pull/7675.



**(d) Static Analysis Tools**

We will run these tools in front of TA in code review.



**(e) Javadoc**

All the generated Javadoc are stored in folder Javadoc.



**(f) JUnit Tests**

For the fifth selected issue, all methods in class MyIcebergConnector will be tested as shown below. 

![JUnitTests5](https://github.com/MirrorChu/Photos/blob/master/progress_report/JUnitTests5.png)

For the fourth selected issue, 5 methods in class BigQueryReadRows will be tested as shown below. 

![JUnitTests4](https://github.com/MirrorChu/Photos/blob/master/progress_report/JUnitTests4.png)

For the third selected issue, all methods in class MyHiveConnector will be tested as shown below. 

![JUnitTests3](https://github.com/MirrorChu/Photos/blob/master/progress_report/JUnitTests3.png)

For the second selected issue, all methods in class MyRaptorConnector will be tested as shown below. 

![JUnitTests2](https://github.com/MirrorChu/Photos/blob/master/progress_report/JUnitTests2.png)

For the first selected issue, 1 method will be tested as shown below.

![JUnitTests1](https://github.com/MirrorChu/Photos/blob/master/progress_report/JUnitTests1.png)



**(g) Future Schedule**

<table>
  <tr>
    <td rowspan="3">Week12</td>
    <td>For issue 7108, construct MyKuduConstructor, reconstruct TestKuduSmokeTestWithStandardInferSchema.</td>
  </tr>
  <tr>
    <td>For issue 2359, modify LdapAuthenticator, modify LdapConfig.</td>
  </tr>
  <tr>
    <td>For issue 2084, modify PhoenixConnector, modify BaseJdbcConfig.</td>
  </tr>
  <tr>
    <td rowspan="3">Week13</td>
    <td>For issue 7108,construct TestKuduWithStandardInferSchemaConnectorTest, reconstruct TestKuduSmokeTestWithEmptyInferSchema.</td>
  </tr>
  <tr>
    <td>For issue 2359, modify LdapAuthenticatorFactory, modify LdapSslSocketFactory.</td>
  </tr>
  <tr>
    <td>For issue 2084, modify BaseJdbcClient, modify JdbcModule.</td>
  </tr>
  <tr>
    <td rowspan="3">Week14</td>
    <td>For issue 7108, construct TestKuduWithEmptyInferSchemaConnectorTest, reconstruct TestKuduDistributedQueries.</td>
  </tr>
  <tr>
    <td>For issue 2359, modify SnglenodeLdap, reconstruct TestLdapAuthenticator.</td>
  </tr>
  <tr>
    <td>For issue 2084, modify ForBaseJdbc, reconstruct TestBaseJdbcConfig.</td>
  </tr>
  <tr>
    <td rowspan="3">Week15</td>
    <td>For issue 7108, reconstruct AbstractKuduIntegrationSmokeTest.</td>
  </tr>
  <tr>
    <td>For issue 2359, reconstruct TestLdapConfig.</td>
  </tr>
  <tr>
    <td>For issue 2084, reconstruct TestPhoenixConnectorTest.</td>
  </tr>
</table>


**(h) Selected Lab Session**

Our selected lab session is (C) Lab Session 3 实验 3 班 Tuesday 10.20-12.10pm(Instructor: Hu Chunfeng), as most of us registered in this session.

<table>
  <tr>
    <th>Group Name</th>
    <th>Student Name</th>
    <th>Student ID</th>
    <th>Selected Project Name</th>
    <th>Selected Project Repo</th>
    <th>Select TA (A-J)</th>
    <th>Select Slot (1-4)</th>
  </tr>
  <tr>
    <td rowspan="5">Bizarre_Group</td>
    <td>孔祥喆</td>
    <td>11811005</td>
    <td rowspan="5">trino TechReborn</td>
    <td rowspan="5">https://github.com/trinodb/trino https://github.com/TechReborn/TechReborn</td>
    <td rowspan="5">E</td>
    <td rowspan="5">slot4</td>
  </tr>
  <tr>
    <td>许博清</td>
    <td>11812910</td>
  </tr>
  <tr>
    <td>李航</td>
    <td>11810910</td>
  </tr>
  <tr>
    <td>寇海龙</td>
    <td>11810610</td>
  </tr>
  <tr>
    <td>黄德淳</td>
    <td>11811002</td>
  </tr>
</table>

