# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table customer (
  customer_id                   varchar(255) not null,
  full_name                     varchar(255) not null,
  email                         varchar(255),
  phone_number                  varchar(255),
  points                        double,
  birth_date                    timestamp,
  user_id                       varchar(255),
  creation_date                 timestamp,
  constraint uq_customer_email unique (email),
  constraint pk_customer primary key (customer_id)
);

create table test (
  id                            bigint not null,
  name                          varchar(255),
  constraint pk_test primary key (id)
);
create sequence test_seq;

create table public.user (
  username                      varchar(255) not null,
  fullname                      varchar(255),
  password                      varchar(255),
  type                          integer,
  constraint ck_user_type check (type in (0,1)),
  constraint pk_user primary key (username)
);


# --- !Downs

drop table if exists customer;

drop table if exists test;
drop sequence if exists test_seq;

drop table if exists public.user;

