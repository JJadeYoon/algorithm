-- 코드를 입력하세요
select fp.PRODUCT_ID, fp.PRODUCT_NAME, sum(fo.amount * fp.price) as "TOTAL_SALES"
from food_order fo
    join food_product fp on fo.product_id = fp.product_id
where fo.produce_date like '2022-05%'
group by fp.product_id
order by 3 desc, 1;