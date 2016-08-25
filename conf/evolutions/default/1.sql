# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table configuration (
  id                            serial not null,
  currency                      varchar(255),
  bonus_points_ratio            float,
  confirm_purchase              boolean,
  constraint pk_configuration primary key (id)
);

create table customer (
  customer_id                   varchar(255) not null,
  full_name                     varchar(255) not null,
  email                         varchar(255),
  phone_number                  varchar(255),
  points                        float,
  birth_date                    timestamp,
  user_id                       varchar(255),
  creation_date                 timestamp default now(),
  constraint uq_customer_email unique (email),
  constraint pk_customer primary key (customer_id)
);

create table test (
  id                            bigserial not null,
  name                          varchar(255),
  constraint pk_test primary key (id)
);

create table transaction (
  transaction_id                varchar(255) not null,
  date                          timestamp default now(),
  description                   varchar(255),
  points                        float,
  type                          varchar(8),
  customer_customer_id          varchar(255),
  constraint ck_transaction_type check (type in ('REDEEM','INVITE','PURCHASE')),
  constraint pk_transaction primary key (transaction_id)
);

create table public.user (
  username                      varchar(255) not null,
  fullname                      varchar(255),
  password                      varchar(255),
  type                          varchar(8),
  constraint ck_user_type check (type in ('CUSTOMER','ADMIN')),
  constraint pk_user primary key (username)
);

create table voucher (
  voucher_id                    integer not null,
  name                          varchar(255),
  description                   varchar(255),
  image_url                     varchar(255),
  points                        float,
  active                        boolean,
  creation_date                 timestamp default now(),
  expiry_date                   timestamp,
  constraint pk_voucher primary key (voucher_id)
);
create sequence voucher_seq;

alter table transaction add constraint fk_transaction_customer_customer_id foreign key (customer_customer_id) references customer (customer_id) on delete restrict on update restrict;
create index ix_transaction_customer_customer_id on transaction (customer_customer_id);


# --- !Downs

alter table if exists transaction drop constraint if exists fk_transaction_customer_customer_id;
drop index if exists ix_transaction_customer_customer_id;

drop table if exists configuration cascade;

drop table if exists customer cascade;

drop table if exists test cascade;

drop table if exists transaction cascade;

drop table if exists public.user cascade;

drop table if exists voucher cascade;
drop sequence if exists voucher_seq;

