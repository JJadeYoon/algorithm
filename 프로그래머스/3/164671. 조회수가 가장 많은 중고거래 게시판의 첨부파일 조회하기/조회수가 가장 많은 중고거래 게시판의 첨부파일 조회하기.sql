select concat('/home/grep/src/', uf.board_id, '/', uf.file_id, uf.file_name, uf.file_ext) as FILE_PATH
from USED_GOODS_FILE uf
where uf.board_id = (select ub.board_id
                     from USED_GOODS_BOARD ub
                     order by ub.views desc
                     limit 1)
order by 1 desc;