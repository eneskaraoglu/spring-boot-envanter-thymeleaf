DROP TABLE V_ENVANTER_DEPO;

CREATE VIEW `V_ENVANTER_DEPO` AS
select
    `a`.`envanter_kodu` AS `envanter_kodu`,
    `a`.`envanter_adi` AS `envanter_adi`,
    `a`.`envanter_miktar` AS `envanter_miktar`,
    `c`.`depo_kod` AS `depo_kod`,
    `c`.`depo_adi` AS `depo_adi`,
    sum(`b`.`depo_miktar`) AS `depo_miktar`,
    `c`.`bolge` AS `bolge`,
    `c`.`sehir` AS `sehir`,
    `c`.`adres` AS `adres`,
    `d`.`katalog_kodu` AS `katalog_kodu`,
    `d`.`katalog_adi` AS `katalog_adi`
from
    (((`t_envanter` `a`
join `t_depo_envanter` `b`)
join `t_depo` `c`)
join `t_katalog` `d`)
where
    ((`a`.`envanter_id` = `b`.`envanter_id`)
        and (`b`.`depo_id` = `c`.`depo_id`)
            and (`a`.`katalog_id` = `d`.`katalog_id`))
group by
    `a`.`envanter_kodu`,
    `a`.`envanter_adi`,
    `a`.`envanter_miktar`,
    `c`.`depo_kod`,
    `c`.`depo_adi`,
    `c`.`bolge`,
    `c`.`sehir`,
    `c`.`adres`,
    `d`.`katalog_kodu`,
    `d`.`katalog_adi`;
    
    
    