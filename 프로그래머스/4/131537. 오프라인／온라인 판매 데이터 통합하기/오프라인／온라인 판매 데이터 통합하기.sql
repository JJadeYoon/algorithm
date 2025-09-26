select date_format(SALES_DATE, '%Y-%m-%d') as "SALES_DATE", PRODUCT_ID, USER_ID, SALES_AMOUNT
from (
    select SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
    from online_sale
    where SALES_DATE >= '2022-03-01'
        and SALES_DATE <= '2022-03-31'
    union all
    select SALES_DATE, PRODUCT_ID, null as USER_ID, SALES_AMOUNT
    from offline_sale
    where SALES_DATE >= '2022-03-01'
        and SALES_DATE <= '2022-03-31'
) sales
order by 1, 2, 3;