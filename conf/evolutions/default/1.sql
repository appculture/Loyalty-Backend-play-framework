# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table test (
  id                            bigserial not null,
  name                          varchar(255),
  constraint pk_test primary key (id)
);

create table public.user (
  username                      varchar(255) not null,
  fullname                      varchar(255),
  password                      varchar(255),
  type                          integer,
  constraint ck_user_type check (type in (0,1)),
  constraint pk_user primary key (username)
);


# --- !Downs

drop table if exists test cascade;

drop table if exists public.user cascade;

