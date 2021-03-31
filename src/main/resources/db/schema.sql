create table users
(
    id       bigserial primary key,
    email    varchar(255),
    enabled  boolean not null,
    password varchar(255),
    username varchar(255)
);

create table posts
(
    id          bigserial primary key,
    created     timestamp,
    description varchar(255),
    name        varchar(255),
    user_id     bigint references users (id)
);

create table comments
(
    id      bigserial primary key,
    created timestamp,
    message varchar(255),
    user_id bigint references users (id)
);

create table posts_comments
(
    post_id     bigint not null references posts (id),
    comments_id bigint not null references comments (id)
);

create table user_role
(
    user_id bigint references users (id),
    roles   varchar(255)
);
