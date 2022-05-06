insert into my_super_entity (id, dtype, country, name, age, city)
values (nextval('HIBERNATE_SEQUENCE'),'default', 'France', null,  null, null);

insert into my_super_entity (id, dtype, name, country, age, city)
values (nextval('HIBERNATE_SEQUENCE'),'Default', 'John', 'France', null, null);

insert into my_super_entity (id, dtype, name, country, age, city)
values (nextval('HIBERNATE_SEQUENCE'),'A', 'Paul', null, '18', null);

insert into my_super_entity (id, dtype, name, country, age, city)
values (nextval('HIBERNATE_SEQUENCE'),'B', 'Henri', null, null, 'Nancy');
