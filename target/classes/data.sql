---------- //// medicines //// -----------
INSERT INTO public.medicines(
    medicine_name, price)
VALUES ('Lovebazine', 6);

INSERT INTO public.medicines(
    medicine_name, price)
VALUES ('Fleximulin', 12.5);

INSERT INTO public.medicines(
    medicine_name, price)
VALUES ('Menotalol', 64);

INSERT INTO public.medicines(
    medicine_name, price)
VALUES ('Butaclude', 126);

INSERT INTO public.medicines(
    medicine_name, price)
VALUES ('Abeltana', 32.5);

INSERT INTO public.medicines(
    medicine_name, price)
VALUES ('Adoxime', 76.2);

INSERT INTO public.medicines(
    medicine_name, price)
VALUES ('Haemonorphine', 12.5);

INSERT INTO public.medicines(
    medicine_name, price)
VALUES ('Oxanlimus', 44);

INSERT INTO public.medicines(
    medicine_name, price)
VALUES ('Cornesin', 12.6);

INSERT INTO public.medicines(
    medicine_name, price)
VALUES ('Prepobulin', 52.3);

---------- //// users //// -----------
INSERT INTO public.users(
    first_name, last_name, address, email, phone_number)
VALUES ('Howard', 'Navarro', '2766  Brown Street, INDIANAPOLIS', 'tybi@1vvb.ru', '+1-555-6652-678');

INSERT INTO public.users(
    first_name, last_name, address, email, phone_number)
VALUES ('Tanya', 'Cherry', '1934  Saints Alley, Tampa', 'slcdltp3@besttempmail.com', '+48-885-5531-42');

INSERT INTO public.users(
    first_name, last_name, address, email, phone_number)
VALUES ('Frank', 'Washington', '335  Patterson Street, Vancouver', 'varso@yarnpedia.ml', '+1-555-5808-376');

INSERT INTO public.users(
    first_name, last_name, address, email, phone_number)
VALUES ('Melinda', 'Lewis', '2887  St Jean Baptiste St, East Broughton', 'Opre1985@cuvox.de', '+1-555-8689-161');

INSERT INTO public.users(
    first_name, last_name, address, email, phone_number)
VALUES ('Martha', 'Brewer', '1480  Eglinton Avenue, Toronto', 'ketiho7046@imail1.net', '+61-455-5670-13');

INSERT INTO public.users(
    first_name, last_name, address, email, phone_number)
VALUES ('Eva', 'Carey', '94 Spencer Street, ORCHID BEACH', 'caleco2460@swift-mail.net', '+61-455-5642-15');

INSERT INTO public.users(
    first_name, last_name, address, email, phone_number)
VALUES ('Victor', 'Newman', '3819  Cottrill Lane, Saint Louis', 'beyijab334@imail1.net', '+48-515-5565-42');

INSERT INTO public.users(
    first_name, last_name, address, email, phone_number)
VALUES ('Jazmin', 'Coleman', '4462  White River Way, Salt Lake City', '6ko4nt3j@meantinc.com', '+48-505-5556-03');

INSERT INTO public.users(
    first_name, last_name, address, email, phone_number)
VALUES ('Erik', 'Roberson', 'Esplanade 32, Barbing', 'm308q2x1@besttempmail.com', '+48-725-5563-38');

INSERT INTO public.users(
    first_name, last_name, address, email, phone_number)
VALUES ('Ryder', 'Harford', '13 Woolnough Road, GLENSIDE', 'tpxtoqad@groupbuff.com', '+8 8304 4133');

INSERT INTO public.users(
    first_name, last_name, address, email, phone_number)
VALUES ('Lara', 'Mowll', '48 Forrest Road, COBBORA', 'julxh65x@classmail.com', '+(02) 4064 2811');

INSERT INTO public.users(
    first_name, last_name, address, email, phone_number)
VALUES ('Yvonne', 'Gaertner', 'Pohlstrasse 49, Liebenburg', 'wksmoucp@power.com', '+5 339 13 01 34');

---------- //// pharmacies //// -----------
INSERT INTO public.pharmacies(
    pharmacy_name, address, email, phone_number)
VALUES ('Supernova', 'ul. Tykocińska 87, Warszawa', 'supernova@pharma.com', '+48-535-5596-63');

INSERT INTO public.pharmacies(
    pharmacy_name, address, email, phone_number)
VALUES ('Eupotorium', 'ul. Cedrowa 97, Poznań', 'eupotorium@pharma.com', '+48-515-5565-42');

INSERT INTO public.pharmacies(
    pharmacy_name, address, email, phone_number)
VALUES ('Parviflora', '2274  Park Ct, Drayton Valley', 'parviflora@pharma.com', '+48-725-5547-13');

---------- //// pharmacy_staff //// -----------
INSERT INTO public.pharmacy_staff(
    user_id, job_title, salary, pharmacy_id)
VALUES (1, 'Pharmacist', 4900, 1);

INSERT INTO public.pharmacy_staff(
    user_id, job_title, salary, pharmacy_id)
VALUES (2, 'Unit Manager', 9000, 1);

INSERT INTO public.pharmacy_staff(
    user_id, job_title, salary, pharmacy_id)
VALUES (3, 'Pharmacist', 3900, 1);

INSERT INTO public.pharmacy_staff(
    user_id, job_title, salary, pharmacy_id)
VALUES (4, 'Pharmacist', 4000, 1);

INSERT INTO public.pharmacy_staff(
    user_id, job_title, salary, pharmacy_id)
VALUES (5, 'Pharmacist', 4800, 2);

INSERT INTO public.pharmacy_staff(
    user_id, job_title, salary, pharmacy_id)
VALUES (6, 'Pharmacist', 4100, 2);

INSERT INTO public.pharmacy_staff(
    user_id, job_title, salary, pharmacy_id)
VALUES (7, 'Unit Manager', 8800, 2);

INSERT INTO public.pharmacy_staff(
    user_id, job_title, salary, pharmacy_id)
VALUES (8, 'Pharmacist', 4400, 2);

INSERT INTO public.pharmacy_staff(
    user_id, job_title, salary, pharmacy_id)
VALUES (9, 'Pharmacist', 4600, 3);

INSERT INTO public.pharmacy_staff(
    user_id, job_title, salary, pharmacy_id)
VALUES (10, 'Unit Manager', 8500, 3);

INSERT INTO public.pharmacy_staff(
    user_id, job_title, salary, pharmacy_id)
VALUES (11, 'Pharmacist', 4200, 3);

INSERT INTO public.pharmacy_staff(
    user_id, job_title, salary, pharmacy_id)
VALUES (12, 'Admin', 7500, 3);

---------- //// pharmacy_storage //// -----------
INSERT INTO public.pharmacy_storage(
    pharmacy_id, medicine_id, quantity)
VALUES (1, 1, 35);

INSERT INTO public.pharmacy_storage(
    pharmacy_id, medicine_id, quantity)
VALUES (1, 2, 35);

INSERT INTO public.pharmacy_storage(
    pharmacy_id, medicine_id, quantity)
VALUES (1, 3, 35);

INSERT INTO public.pharmacy_storage(
    pharmacy_id, medicine_id, quantity)
VALUES (1, 4, 35);

INSERT INTO public.pharmacy_storage(
    pharmacy_id, medicine_id, quantity)
VALUES (1, 5, 35);

INSERT INTO public.pharmacy_storage(
    pharmacy_id, medicine_id, quantity)
VALUES (1, 6, 35);

INSERT INTO public.pharmacy_storage(
    pharmacy_id, medicine_id, quantity)
VALUES (1, 7, 35);

INSERT INTO public.pharmacy_storage(
    pharmacy_id, medicine_id, quantity)
VALUES (1, 8, 35);

INSERT INTO public.pharmacy_storage(
    pharmacy_id, medicine_id, quantity)
VALUES (1, 9, 35);

INSERT INTO public.pharmacy_storage(
    pharmacy_id, medicine_id, quantity)
VALUES (1, 10, 35);

INSERT INTO public.pharmacy_storage(
    pharmacy_id, medicine_id, quantity)
VALUES (2, 1, 25);

INSERT INTO public.pharmacy_storage(
    pharmacy_id, medicine_id, quantity)
VALUES (2, 2, 25);

INSERT INTO public.pharmacy_storage(
    pharmacy_id, medicine_id, quantity)
VALUES (2, 3, 25);

INSERT INTO public.pharmacy_storage(
    pharmacy_id, medicine_id, quantity)
VALUES (2, 4, 25);

INSERT INTO public.pharmacy_storage(
    pharmacy_id, medicine_id, quantity)
VALUES (2, 5, 25);

INSERT INTO public.pharmacy_storage(
    pharmacy_id, medicine_id, quantity)
VALUES (2, 6, 25);

INSERT INTO public.pharmacy_storage(
    pharmacy_id, medicine_id, quantity)
VALUES (2, 7, 25);

INSERT INTO public.pharmacy_storage(
    pharmacy_id, medicine_id, quantity)
VALUES (2, 8, 25);

INSERT INTO public.pharmacy_storage(
    pharmacy_id, medicine_id, quantity)
VALUES (2, 9, 25);

INSERT INTO public.pharmacy_storage(
    pharmacy_id, medicine_id, quantity)
VALUES (2, 10, 25);

INSERT INTO public.pharmacy_storage(
    pharmacy_id, medicine_id, quantity)
VALUES (3, 1, 45);

INSERT INTO public.pharmacy_storage(
    pharmacy_id, medicine_id, quantity)
VALUES (3, 2, 45);

INSERT INTO public.pharmacy_storage(
    pharmacy_id, medicine_id, quantity)
VALUES (3, 3, 45);

INSERT INTO public.pharmacy_storage(
    pharmacy_id, medicine_id, quantity)
VALUES (3, 4, 45);

INSERT INTO public.pharmacy_storage(
    pharmacy_id, medicine_id, quantity)
VALUES (3, 5, 45);

INSERT INTO public.pharmacy_storage(
    pharmacy_id, medicine_id, quantity)
VALUES (3, 6, 45);

INSERT INTO public.pharmacy_storage(
    pharmacy_id, medicine_id, quantity)
VALUES (3, 7, 45);

INSERT INTO public.pharmacy_storage(
    pharmacy_id, medicine_id, quantity)
VALUES (3, 8, 45);

INSERT INTO public.pharmacy_storage(
    pharmacy_id, medicine_id, quantity)
VALUES (3, 9, 45);

INSERT INTO public.pharmacy_storage(
    pharmacy_id, medicine_id, quantity)
VALUES (3, 10, 45);

---------- //// user_credentials //// -----------
INSERT INTO public.user_credentials(
    login, password, user_id)
VALUES ('hownav', 'howvan2019', 1);

INSERT INTO public.user_credentials(
    login, password, user_id)
VALUES ('tanche', 'tanche2019', 2);

INSERT INTO public.user_credentials(
    login, password, user_id)
VALUES ('frawas', 'frawas2019', 3);

INSERT INTO public.user_credentials(
    login, password, user_id)
VALUES ('melles', 'melles2019', 4);

INSERT INTO public.user_credentials(
    login, password, user_id)
VALUES ('marbre', 'marbre2019', 5);

INSERT INTO public.user_credentials(
    login, password, user_id)
VALUES ('evacar', 'evacar2019', 6);

INSERT INTO public.user_credentials(
    login, password, user_id)
VALUES ('vicnew', 'vicnew2019', 7);

INSERT INTO public.user_credentials(
    login, password, user_id)
VALUES ('jazcol', 'jazcol2019', 8);

INSERT INTO public.user_credentials(
    login, password, user_id)
VALUES ('erirob', 'erirob2019', 9);

INSERT INTO public.user_credentials(
    login, password, user_id)
VALUES ('rydhar', 'rydhar2019', 10);

INSERT INTO public.user_credentials(
    login, password, user_id)
VALUES ('larmow', 'larmow2019', 11);

INSERT INTO public.user_credentials(
    login, password, user_id)
VALUES ('yvogae', 'yvogae2019', 12);