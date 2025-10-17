select date_format(sales_date, '%Y-%m-%d') as SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
from (
    select sales_date, product_id, user_id, sales_amount
    from online_sale

    
    union all
    
    select sales_date, product_id, null as user_id, sales_amount
    from offline_sale

) sales
where sales_date >= '2022-03-01' and sales_date <= '2022-03-31'
order by 1, 2, 3


