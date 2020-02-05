CREATE TABLE project
  ( proid NUMBER(6) PRIMARY KEY, 
    proname VARCHAR2(20)
  );
  
CREATE TABLE employee
  ( empid NUMBER(6) PRIMARY KEY,
    empname VARCHAR2(20)
  );
  
CREATE TABLE proemp
  ( rproid  NUMBER(6), 
    rempid  NUMBER(6)
  );

alter table proemp add constraint fk_rproid foreign key (rproid) references project(proid);
alter table proemp add constraint fk_rempid foreign key (rempid) references employee(empid);	

select * from project;
select * from employee;
select * from proemp;