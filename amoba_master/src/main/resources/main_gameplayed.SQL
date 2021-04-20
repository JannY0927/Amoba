-- auto-generated definition
create table GAMEPLAYED
(
    step_id   integer not null
        constraint GAMEPLAYED_pk
            primary key autoincrement,
    game_id   integer not null,
    stepx     integer not null,
    stepy     integer not null,
    signValue text    not null
);