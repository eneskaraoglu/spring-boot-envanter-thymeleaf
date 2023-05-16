INSERT INTO t_depo (depo_kod,depo_adi,bolge,sehir,adres) VALUES
	 ('D1','Depo 1','İç Anadolu',NULL,NULL),
	 ('D2','Depo 2','Akdeniz',NULL,NULL),
	 ('D3','Depo 3','Ege',NULL,NULL);

INSERT INTO t_katalog (katalog_adi,katalog_kodu) VALUES
	 ('Katalog 1','K1'),
	 ('Katalog 2','K2'),
	 ('Katalog 3','K3');
	 
INSERT INTO t_envanter (envanter_adi,envanter_kodu,envanter_miktar,kritik_miktar,katalog_id) VALUES
	 ('H001','Somun',100,1000,1),
	 ('H002','Vida',400,1000,1),
	 ('Y002','V2 Yarı Mamü',750,200,2),
	 ('Y001','AZ2 Yarı Mamül',500,100,2),	 
	 ('SON1','Kalem',125,100,3),
	 ('SON2','Bike',900,75,3),
	 ('SON3','Mouse',450,50,3);

INSERT INTO t_depo_envanter (depo_id,envanter_id,depo_miktar) VALUES
	 (1,1,100),
	 (1,2,0),
	 (2,1,200),
	 (2,2,150),
	 (2,3,50),
	 (3,2,750),
	 (4,3,150),
	 (4,2,350),
	 (5,2,125),
	 (6,3,750),
	 (6,2,150),
	 (7,3,100),
	 (7,2,350);
