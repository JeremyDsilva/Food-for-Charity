    select
        person0_.id as id1_14_,
        person0_.last_login_time as last_login_time2_14_,
        person0_.password_hash as password_hash3_14_,
        person0_.password_salt as password_salt4_14_,
        person0_.username as username5_14_,
        person0_4_.role_id as role_id1_25_,
        person0_2_.address_description as address_descriptio1_4_,
        person0_2_.city as city2_4_,
        person0_2_.country as country3_4_,
        person0_2_.donee_name as donee_name4_4_,
        person0_2_.donee_status_id as donee_status_id10_4_,
        person0_2_.donee_type_id as donee_type_id11_4_,
        person0_2_.email as email5_4_,
        person0_2_.member_count as member_count6_4_,
        person0_2_.phone_number as phone_number7_4_,
        person0_2_.quantity_requested as quantity_requested8_4_,
        person0_3_.address_description as address_descriptio1_9_,
        person0_3_.city as city2_9_,
        person0_3_.country as country3_9_,
        person0_3_.donor_name as donor_name4_9_,
        person0_3_.donor_status_id as donor_status_id10_9_,
        person0_3_.email as email5_9_,
        person0_3_.number_of_rating as number_of_rating6_9_,
        person0_3_.phone_number as phone_number7_9_,
        person0_3_.rating as rating8_9_,
        case
            when person0_1_.person_id is not null then 1 
            when person0_2_.person_id is not null then 2
            when person0_3_.person_id is not null then 3
            when person0_.id is not null then 0
        end as clazz_
    from
        b00074902.person person0_
    left outer join
        b00074902.broker person0_1_
            on person0_.id=person0_1_.person_id
    left outer join
        b00074902.donee person0_2_
            on person0_.id=person0_2_.person_id
    left outer join
        b00074902.donor person0_3_ 
            on person0_.id=person0_3_.person_id
    left outer join
        map_person_role person0_4_
            on person0_.id=person0_4_.person_id
    where
        person0_.username='AnnitaRosinski';