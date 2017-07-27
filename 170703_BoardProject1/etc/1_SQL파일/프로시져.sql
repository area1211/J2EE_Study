DELIMITER $$
DROP PROCEDURE IF EXISTS uploadPost$$
CREATE PROCEDURE uploadPost(pc_subject varchar(20), pc_title varchar(100), pc_date timestamp, pc_body text
, pc_public tinyint, pc_pid int, pc_mb_id int, pc_u_nickname varchar(20), pc_hits int)
BEGIN
	DECLARE user_id varchar(20);
	SET user_id = (SELECT u_id FROM user_tb WHERE user_tb.u_nickname = pc_u_nickname);
	
	INSERT INTO post_tb (p_subject, p_title, p_date, p_body, p_public, p_pid, mb_id, u_id, p_hits)
	VALUES (pc_subject, pc_title, pc_date, pc_body, pc_public, pc_pid, pc_mb_id, user_id, pc_hits);

END$$

CALL uploadPost('none', '프로시져테스트', '2017-07-05 12:39:00', '프로시져는쉬워라', 1, 0, 1, '정이노', 0);

select * from post_tb where p_id >= 30;