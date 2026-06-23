--
-- PostgreSQL database dump
--

\restrict Nv8L9f3NlxsSzFbSfvAYBY5jQWeyV2WmAGHTyciQBJqnGAOwJeFlgMFyvtVcGOv

-- Dumped from database version 18.1 (Postgres.app)
-- Dumped by pg_dump version 18.0

-- Started on 2026-06-23 10:40:26 IST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 230 (class 1259 OID 16676)
-- Name: alerts; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.alerts (
    alert_id bigint NOT NULL,
    alert_type character varying(255),
    drug_name character varying(255),
    message character varying(255),
    alert_date date,
    priority character varying(255)
);


ALTER TABLE public.alerts OWNER TO postgres;

--
-- TOC entry 229 (class 1259 OID 16675)
-- Name: alerts_alert_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.alerts_alert_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.alerts_alert_id_seq OWNER TO postgres;

--
-- TOC entry 3790 (class 0 OID 0)
-- Dependencies: 229
-- Name: alerts_alert_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.alerts_alert_id_seq OWNED BY public.alerts.alert_id;


--
-- TOC entry 228 (class 1259 OID 16647)
-- Name: drug_requests; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.drug_requests (
    request_id bigint NOT NULL,
    hospital character varying(255),
    drug character varying(255),
    requested_qty integer,
    requested_date date,
    status character varying(255)
);


ALTER TABLE public.drug_requests OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 16646)
-- Name: drug_requests_request_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.drug_requests_request_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.drug_requests_request_id_seq OWNER TO postgres;

--
-- TOC entry 3791 (class 0 OID 0)
-- Dependencies: 227
-- Name: drug_requests_request_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.drug_requests_request_id_seq OWNED BY public.drug_requests.request_id;


--
-- TOC entry 220 (class 1259 OID 16566)
-- Name: drugs; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.drugs (
    drug_id bigint NOT NULL,
    drug_name character varying(255),
    category character varying(255),
    batch_no character varying(255),
    expiry_date date,
    stock integer
);


ALTER TABLE public.drugs OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16565)
-- Name: drugs_drug_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.drugs_drug_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.drugs_drug_id_seq OWNER TO postgres;

--
-- TOC entry 3792 (class 0 OID 0)
-- Dependencies: 219
-- Name: drugs_drug_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.drugs_drug_id_seq OWNED BY public.drugs.drug_id;


--
-- TOC entry 234 (class 1259 OID 16712)
-- Name: settings; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.settings (
    setting_id bigint NOT NULL,
    hospital_name character varying(255),
    email character varying(255),
    phone character varying(255),
    low_stock_threshold integer,
    expiry_alert_days integer,
    email_notifications character varying(255),
    sms_notifications character varying(255),
    backup_frequency character varying(255)
);


ALTER TABLE public.settings OWNER TO postgres;

--
-- TOC entry 233 (class 1259 OID 16711)
-- Name: settings_setting_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.settings_setting_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.settings_setting_id_seq OWNER TO postgres;

--
-- TOC entry 3793 (class 0 OID 0)
-- Dependencies: 233
-- Name: settings_setting_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.settings_setting_id_seq OWNED BY public.settings.setting_id;


--
-- TOC entry 226 (class 1259 OID 16612)
-- Name: shipments; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.shipments (
    shipment_id bigint NOT NULL,
    order_id bigint NOT NULL,
    shipment_date character varying(255) NOT NULL,
    expected_delivery character varying(255) NOT NULL,
    status character varying(255) NOT NULL
);


ALTER TABLE public.shipments OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 16611)
-- Name: shipments_shipment_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.shipments_shipment_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.shipments_shipment_id_seq OWNER TO postgres;

--
-- TOC entry 3794 (class 0 OID 0)
-- Dependencies: 225
-- Name: shipments_shipment_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.shipments_shipment_id_seq OWNED BY public.shipments.shipment_id;


--
-- TOC entry 224 (class 1259 OID 16602)
-- Name: supply_orders; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.supply_orders (
    order_id bigint NOT NULL,
    vendor character varying(255),
    order_date date,
    total_amount numeric(38,2),
    status character varying(255)
);


ALTER TABLE public.supply_orders OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 16601)
-- Name: supply_orders_order_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.supply_orders_order_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.supply_orders_order_id_seq OWNER TO postgres;

--
-- TOC entry 3795 (class 0 OID 0)
-- Dependencies: 223
-- Name: supply_orders_order_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.supply_orders_order_id_seq OWNED BY public.supply_orders.order_id;


--
-- TOC entry 232 (class 1259 OID 16694)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    user_id bigint NOT NULL,
    full_name character varying(255),
    email character varying(255),
    phone character varying(255),
    role character varying(255),
    username character varying(255),
    password character varying(255),
    status character varying(255)
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 231 (class 1259 OID 16693)
-- Name: users_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.users_user_id_seq OWNER TO postgres;

--
-- TOC entry 3796 (class 0 OID 0)
-- Dependencies: 231
-- Name: users_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_user_id_seq OWNED BY public.users.user_id;


--
-- TOC entry 222 (class 1259 OID 16584)
-- Name: vendors; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vendors (
    vendor_id bigint NOT NULL,
    vendor_name character varying(255),
    contact_person character varying(255),
    phone character varying(255),
    email character varying(255)
);


ALTER TABLE public.vendors OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16583)
-- Name: vendors_vendor_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.vendors_vendor_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.vendors_vendor_id_seq OWNER TO postgres;

--
-- TOC entry 3797 (class 0 OID 0)
-- Dependencies: 221
-- Name: vendors_vendor_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.vendors_vendor_id_seq OWNED BY public.vendors.vendor_id;


--
-- TOC entry 3603 (class 2604 OID 16683)
-- Name: alerts alert_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.alerts ALTER COLUMN alert_id SET DEFAULT nextval('public.alerts_alert_id_seq'::regclass);


--
-- TOC entry 3602 (class 2604 OID 16650)
-- Name: drug_requests request_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.drug_requests ALTER COLUMN request_id SET DEFAULT nextval('public.drug_requests_request_id_seq'::regclass);


--
-- TOC entry 3598 (class 2604 OID 16573)
-- Name: drugs drug_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.drugs ALTER COLUMN drug_id SET DEFAULT nextval('public.drugs_drug_id_seq'::regclass);


--
-- TOC entry 3605 (class 2604 OID 16719)
-- Name: settings setting_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.settings ALTER COLUMN setting_id SET DEFAULT nextval('public.settings_setting_id_seq'::regclass);


--
-- TOC entry 3601 (class 2604 OID 16623)
-- Name: shipments shipment_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.shipments ALTER COLUMN shipment_id SET DEFAULT nextval('public.shipments_shipment_id_seq'::regclass);


--
-- TOC entry 3600 (class 2604 OID 16605)
-- Name: supply_orders order_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supply_orders ALTER COLUMN order_id SET DEFAULT nextval('public.supply_orders_order_id_seq'::regclass);


--
-- TOC entry 3604 (class 2604 OID 16701)
-- Name: users user_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN user_id SET DEFAULT nextval('public.users_user_id_seq'::regclass);


--
-- TOC entry 3599 (class 2604 OID 16587)
-- Name: vendors vendor_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendors ALTER COLUMN vendor_id SET DEFAULT nextval('public.vendors_vendor_id_seq'::regclass);


--
-- TOC entry 3780 (class 0 OID 16676)
-- Dependencies: 230
-- Data for Name: alerts; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.alerts (alert_id, alert_type, drug_name, message, alert_date, priority) FROM stdin;
11	Low Stock	Paracetamol	Stock below 100 units	2026-06-15	High
12	Low Stock	Metformin	Stock below 100 units	2026-06-15	High
\.


--
-- TOC entry 3778 (class 0 OID 16647)
-- Dependencies: 228
-- Data for Name: drug_requests; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.drug_requests (request_id, hospital, drug, requested_qty, requested_date, status) FROM stdin;
2	Fortis Hospital	Amoxicillin	80	2026-06-02	Delivered
3	CMC Hospital	Ibuprofen	60	2026-06-03	Confirmed
6	Apollo Hospital	Aspirin	70	2026-06-06	Delivered
7	Fortis Hospital	Dolo 650	90	2026-06-07	Pending
8	CMC Hospital	Cetirizine	45	2026-06-08	Confirmed
9	Global Hospital	Azithromycin	55	2026-06-09	Delivered
10	MIOT Hospital	Pantoprazole	75	2026-06-10	Pending
11	Apollo Hospital	Insulin	30	2026-06-11	Delivered
12	Fortis Hospital	Omeprazole	20	2026-06-12	In Transit
13	CMC Hospital	Vitamin D	50	2026-06-13	Confirmed
14	Global Hospital	Crocin	65	2026-06-14	Pending
15	MIOT Hospital	Ciprofloxacin	45	2026-06-15	Delivered
16	Apollo Hospital	Dexamethasone	35	2026-06-16	Confirmed
17	Fortis Hospital	Diclofenac	55	2026-06-17	Cancelled
18	CMC Hospital	Levocetirizine	40	2026-06-18	Delivered
19	Global Hospital	Losartan	25	2026-06-19	Pending
20	MIOT Hospital	Atorvastatin	60	2026-06-20	Confirmed
4	Global Hospital	Vitamin C	50	2026-06-04	Delivered
1	Apollo Hospital	Paracetamol	100	2026-06-14	Delivered
\.


--
-- TOC entry 3770 (class 0 OID 16566)
-- Dependencies: 220
-- Data for Name: drugs; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.drugs (drug_id, drug_name, category, batch_no, expiry_date, stock) FROM stdin;
4	Amoxicillin	Antibiotics	B004	2026-06-14	600
7	Ciprofloxacin	Antibiotics	B1006	2028-03-12	350
9	Insulin	Diabetes Care	B1008	2027-09-30	150
10	Glimepiride	Diabetes Care	B1009	2028-02-18	275
12	Vitamin D3	Vitamins	B1011	2028-05-20	550
13	Multivitamin	Vitamins	B1012	2027-07-14	400
14	Cetirizine	Allergy	B1013	2027-10-05	180
15	Loratadine	Allergy	B1014	2028-01-22	220
16	Omeprazole	Gastro Care	B1015	2028-04-08	320
17	Pantoprazole	Gastro Care	B1016	2027-11-11	280
18	Salbutamol	Respiratory	B1017	2028-07-09	140
19	Montelukast	Respiratory	B1018	2028-03-30	190
21	Zinc Tablets	Supplements	B1020	2028-06-25	120
2	Ibuprofen	Pain Relief	B002	2026-06-14	151
5	Azithromycin	Antibiotics	B005	2026-06-14	101
1	Paracetamol	Pain Relief	B001	2026-06-14	84
8	Metformin	Diabetes Care	B1007	2028-06-15	0
22	fever tablet	pain relief	B0022	2026-06-15	120
3	Aspirin	Pain Relief	B003	2026-06-14	401
11	Vitamin C	Vitamins	B1010	2027-12-01	100
\.


--
-- TOC entry 3784 (class 0 OID 16712)
-- Dependencies: 234
-- Data for Name: settings; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.settings (setting_id, hospital_name, email, phone, low_stock_threshold, expiry_alert_days, email_notifications, sms_notifications, backup_frequency) FROM stdin;
1	ABC Medical Store	bloodbank.admin@gmail.com	9876543210	100	30	Enabled	Disabled	Weekly
\.


--
-- TOC entry 3776 (class 0 OID 16612)
-- Dependencies: 226
-- Data for Name: shipments; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.shipments (shipment_id, order_id, shipment_date, expected_delivery, status) FROM stdin;
4	104	2026-06-04	2026-06-08	Confirmed
6	106	2026-06-06	2026-06-10	Delivered
7	107	2026-06-07	2026-06-11	In Transit
9	109	2026-06-09	2026-06-13	Confirmed
10	110	2026-06-10	2026-06-14	Cancelled
11	111	2026-06-11	2026-06-15	Delivered
12	112	2026-06-12	2026-06-16	In Transit
13	113	2026-06-13	2026-06-17	Pending
14	114	2026-06-14	2026-06-18	Confirmed
15	115	2026-06-15	2026-06-19	Cancelled
16	116	2026-06-16	2026-06-20	Delivered
17	117	2026-06-17	2026-06-21	In Transit
18	118	2026-06-18	2026-06-22	Pending
19	119	2026-06-19	2026-06-23	Confirmed
20	120	2026-06-20	2026-06-24	Delivered
3	103	2026-06-03	2026-06-07	Delivered
1	101	2026-05-01 +05:30	2026-05-30 +05:30	Delivered
8	108	2026-04-01 +05:30	2026-04-30 +05:30	Delivered
2	102	2026-06-02 +05:30	2026-06-06 +05:30	Delivered
5	105	2026-06-05 +05:30	2026-06-09 +05:30	Pending
\.


--
-- TOC entry 3774 (class 0 OID 16602)
-- Dependencies: 224
-- Data for Name: supply_orders; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.supply_orders (order_id, vendor, order_date, total_amount, status) FROM stdin;
2	ABC Pharma	2026-06-14	25000.00	Delivered
3	MediLife Pharma	2026-06-01	12000.00	Delivered
6	PharmaCorp	2026-06-04	20000.00	Confirmed
7	LifeCare Supplies	2026-06-05	7000.00	Cancelled
8	Prime Meds	2026-06-06	18000.00	Delivered
9	Apollo Drugs	2026-06-07	9200.00	Pending
10	Nova Pharma	2026-06-08	14500.00	In Transit
11	BioCare	2026-06-09	11200.00	Confirmed
12	Wellness Pharma	2026-06-10	16500.00	Cancelled
13	United Meds	2026-06-11	19000.00	Delivered
15	Sun Pharma	2026-06-13	12600.00	In Transit
16	Elite Meds	2026-06-14	15300.00	Confirmed
17	Max Pharma	2026-06-15	21000.00	Delivered
18	Care Drugs	2026-06-16	9700.00	Cancelled
19	MediSource	2026-06-17	13500.00	Pending
20	PharmaOne	2026-06-18	22000.00	Delivered
21	LifeLine Meds	2026-06-19	17500.00	Confirmed
22	Health First	2026-06-20	8900.00	In Transit
4	HealthCare Ltd	2026-06-02	8500.00	Delivered
5	Global Medicine	2026-06-03	15000.00	Delivered
14	Green Health	2026-06-12	8400.00	Delivered
\.


--
-- TOC entry 3782 (class 0 OID 16694)
-- Dependencies: 232
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (user_id, full_name, email, phone, role, username, password, status) FROM stdin;
2	Priya	priya@gmail.com	9876543212	Store Manager	priya	123	Inactive
3	Arun Kumar	arun@gmail.com	9876543211	Pharmacist	arun	123	Active
1	HEMALATHA M	bloodbank.admin@gmail.com	9876543210	Admin	Hemalatha	admin123	Active
\.


--
-- TOC entry 3772 (class 0 OID 16584)
-- Dependencies: 222
-- Data for Name: vendors; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.vendors (vendor_id, vendor_name, contact_person, phone, email) FROM stdin;
3	HealthCare Ltd	Michael	9876543212	michael@healthcare.com
4	Apollo Drugs	James	9876543213	james@apollo.com
5	Prime Meds	Robert	9876543214	robert@prime.com
6	CarePlus Pharma	William	9876543215	william@careplus.com
7	Nova Drugs	Daniel	9876543216	daniel@nova.com
8	LifeLine Meds	Joseph	9876543217	joseph@lifeline.com
9	MediHub	Thomas	9876543218	thomas@medihub.com
10	Health First	Richard	9876543219	richard@healthfirst.com
11	BioCare	Henry	9876543220	henry@biocare.com
12	Wellness Pharma	Charles	9876543221	charles@wellness.com
13	United Meds	Christopher	9876543222	chris@united.com
14	Green Health	Matthew	9876543223	matthew@green.com
15	Sun Pharma	Andrew	9876543224	andrew@sun.com
16	MediSource	Anthony	9876543225	anthony@source.com
17	PharmaOne	Mark	9876543226	mark@pharmaone.com
18	Elite Meds	Steven	9876543227	steven@elite.com
19	Care Drugs	Paul	9876543228	paul@caredrugs.com
20	Max Pharma	Kevin	9876543229	kevin@max.com
1	MediLife	John Smith	9876543210	johnm@medilife.com
\.


--
-- TOC entry 3798 (class 0 OID 0)
-- Dependencies: 229
-- Name: alerts_alert_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.alerts_alert_id_seq', 13, true);


--
-- TOC entry 3799 (class 0 OID 0)
-- Dependencies: 227
-- Name: drug_requests_request_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.drug_requests_request_id_seq', 20, true);


--
-- TOC entry 3800 (class 0 OID 0)
-- Dependencies: 219
-- Name: drugs_drug_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.drugs_drug_id_seq', 22, true);


--
-- TOC entry 3801 (class 0 OID 0)
-- Dependencies: 233
-- Name: settings_setting_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.settings_setting_id_seq', 1, true);


--
-- TOC entry 3802 (class 0 OID 0)
-- Dependencies: 225
-- Name: shipments_shipment_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.shipments_shipment_id_seq', 20, true);


--
-- TOC entry 3803 (class 0 OID 0)
-- Dependencies: 223
-- Name: supply_orders_order_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.supply_orders_order_id_seq', 22, true);


--
-- TOC entry 3804 (class 0 OID 0)
-- Dependencies: 231
-- Name: users_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_user_id_seq', 3, true);


--
-- TOC entry 3805 (class 0 OID 0)
-- Dependencies: 221
-- Name: vendors_vendor_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.vendors_vendor_id_seq', 20, true);


--
-- TOC entry 3617 (class 2606 OID 16685)
-- Name: alerts alerts_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.alerts
    ADD CONSTRAINT alerts_pkey PRIMARY KEY (alert_id);


--
-- TOC entry 3615 (class 2606 OID 16653)
-- Name: drug_requests drug_requests_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.drug_requests
    ADD CONSTRAINT drug_requests_pkey PRIMARY KEY (request_id);


--
-- TOC entry 3607 (class 2606 OID 16575)
-- Name: drugs drugs_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.drugs
    ADD CONSTRAINT drugs_pkey PRIMARY KEY (drug_id);


--
-- TOC entry 3621 (class 2606 OID 16721)
-- Name: settings settings_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.settings
    ADD CONSTRAINT settings_pkey PRIMARY KEY (setting_id);


--
-- TOC entry 3613 (class 2606 OID 16625)
-- Name: shipments shipments_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.shipments
    ADD CONSTRAINT shipments_pkey PRIMARY KEY (shipment_id);


--
-- TOC entry 3611 (class 2606 OID 16608)
-- Name: supply_orders supply_orders_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supply_orders
    ADD CONSTRAINT supply_orders_pkey PRIMARY KEY (order_id);


--
-- TOC entry 3619 (class 2606 OID 16703)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);


--
-- TOC entry 3609 (class 2606 OID 16590)
-- Name: vendors vendors_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendors
    ADD CONSTRAINT vendors_pkey PRIMARY KEY (vendor_id);


-- Completed on 2026-06-23 10:40:46 IST

--
-- PostgreSQL database dump complete
--

\unrestrict Nv8L9f3NlxsSzFbSfvAYBY5jQWeyV2WmAGHTyciQBJqnGAOwJeFlgMFyvtVcGOv

