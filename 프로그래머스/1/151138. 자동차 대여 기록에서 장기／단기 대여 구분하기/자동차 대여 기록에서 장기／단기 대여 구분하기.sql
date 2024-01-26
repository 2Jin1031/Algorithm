SELECT history_id, car_id, DATE_FORMAT(start_date, '%Y-%m-%d') START_DATE,
        DATE_FORMAT(end_date, '%Y-%m-%d') END_DATE,
        CASE WHEN DATEDIFF(end_date, start_date)+1 >= 30 THEN '장기 대여'
                ELSE '단기 대여'
            END AS RENT_TYPE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE START_DATE LIKE '%2022-09%'
ORDER BY history_id DESC;