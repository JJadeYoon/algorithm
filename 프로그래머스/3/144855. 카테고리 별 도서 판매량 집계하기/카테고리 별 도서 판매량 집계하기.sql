select b.category, sum(bs.sales) as "TOTAL_SALES"
from BOOK b join BOOK_SALES bs on b.book_id = bs.book_id
where bs.sales_date like ('2022-01%')
group by b.category
order by b.category;