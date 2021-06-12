create table messages
(
    id serial,
    message varchar(1000)
);

create unique index messages_id_uindex
    on messages (id);

alter table messages
    add constraint messages_pk
        primary key (id);

INSERT INTO public.messages (id, message) VALUES (DEFAULT, 'Hoi Rick')