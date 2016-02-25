INSERT INTO MENU (NAME, TYPE, PARENT_ID, DEPTH, ORDER_IN_DEPTH, URI) VALUES
  ('Site''s home', 'R', 0, 0, 1, '')
, ('우주', 'L', 1, 1, 1, 'wuzu')
, ('우주인', 'L', 1, 1, 2, 'wuzu-in')
, ('초능력', 'L', 1, 1, 3, 'esp')
, ('에너지', 'L', 1, 1, 4, 'energy')
, ('손가락', 'L', 1, 1, 5, 'finger')
;

--SELECT *
--FROM MENU
--WHERE DEPTH BETWEEN 1 AND 1
--ORDER BY ORDER_IN_DEPTH
--;

--DEPTH 별로 정렬하는 쿼리를 만들어야함!