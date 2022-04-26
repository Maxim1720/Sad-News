insert into user_info (id, firstname, lastname, secondname)
values (1,'Maksim', 'Musiev','Alibekovich');
insert into user_account (user_account_id, login, password, user_info_id)
values (1,'login','password',1);
insert into public.category (id, name)
values (1,'Россия');
insert into rubric (id, name, category_id)
values (1,'Общество',1);