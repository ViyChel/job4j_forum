insert into users (username, email, password, enabled)
values ('user', 'user@email.com', '123456', true),
       ('root', 'root@email.com', '123456', true);

insert into posts (name, description, user_id)
values ('Продаю автомобиль Лада-Калина', 'В отличном состоянии. Пробег 55000 км.', 1);

insert into posts (name, description, user_id)
values ('Продаю автомобиль BMW X5', 'Дорого. Пробег 15000 км.', 2);