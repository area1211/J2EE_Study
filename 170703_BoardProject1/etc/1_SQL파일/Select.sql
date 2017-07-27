select count(p_id) from post_tb;
select p_id, p_subject, p_title, (select u_nickname from user_tb where user_tb.u_id = post_tb.u_id) , p_date, p_body, p_public, p_id, p_hits 
from post_tb where mb_id=1 and p_id >= 1 and p_id <= 10;
