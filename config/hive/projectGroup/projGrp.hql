set DB=${hiveconf:db_name};
set DB_ROLE=${hiveconf:db_role};
create database ${hiveconf:DB};
use ${hiveconf:DB};

CREATE VIEW IF NOT EXISTS affiliation AS select * from default.affiliation where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS bedinventory AS select * from default.bedinventory where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS client AS select * from default.client where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS commercialsexualexploitation AS select * from default.commercialsexualexploitation where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS connectionwithsoar AS select * from default.connectionwithsoar where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS dateofengagement AS select * from default.dateofengagement where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS disabilities AS select * from default.disabilities where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS domesticviolence AS select * from default.domesticviolence where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS employment AS select * from default.employment where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS enrollment AS select * from default.enrollment where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS enrollment_coc AS select * from default.enrollment_coc where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS exit AS select * from default.exit where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS exithousingassessment AS select * from default.exithousingassessment where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS exitplansactions AS select * from default.exitplansactions where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS familyreunification AS select * from default.familyreunification where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS formerwardchildwelfare AS select * from default.formerwardchildwelfare where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS formerwardjuvenilejustice AS select * from default.formerwardjuvenilejustice where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS funder AS select * from default.funder where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS health_status AS select * from default.health_status where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS healthinsurance AS select * from default.healthinsurance where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS housingassessmentdisposition AS select * from default.housingassessmentdisposition where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS incomeandsources AS select * from default.incomeandsources where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS inventory AS select * from default.inventory where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS lastgradecompleted  AS select * from default.lastgradecompleted where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS lastpermanentaddress AS select * from default.lastpermanentaddress where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS medicalassistance AS select * from default.medicalassistance where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS noncashbenefits AS select * from default.noncashbenefits where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS organization AS select * from default.organization where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS path_status AS select * from default.path_status where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS percent_ami AS select * from default.percent_ami where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS project AS select * from default.project where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS projectcoc AS select * from default.projectcoc where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS projectcompletionstatus AS select * from default.projectcompletionstatus where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS referralsource AS select * from default.referralsource where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS residentialmoveindate AS select * from default.residentialmoveindate where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS rhybcp_status AS select * from default.rhybcp_status where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS schoolstatus AS select * from default.schoolstatus where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS services AS select * from default.services where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS sexualorientation AS select * from default.sexualorientation where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS site AS select * from default.site where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS veteran_info AS select * from default.veteran_info where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS worsthousingsituation AS select * from default.worsthousingsituation where deleted='false' and  project_group_code='${hiveconf:DB}';
CREATE VIEW IF NOT EXISTS youthcriticalissues AS select * from default.youthcriticalissues where deleted='false' and  project_group_code='${hiveconf:DB}';

create role ${hiveconf:DB_ROLE};
grant select on database ${hiveconf:DB} to role ${hiveconf:DB_ROLE};