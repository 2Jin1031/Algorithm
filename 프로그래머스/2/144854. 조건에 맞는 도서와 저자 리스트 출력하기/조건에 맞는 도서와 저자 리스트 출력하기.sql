SELECT BOOK_ID, AUTHOR_NAME, DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE
FROM BOOK b JOIN AUTHOR a
WHERE b.AUTHOR_ID = a.AUTHOR_ID AND CATEGORY = '경제'
ORDER BY PUBLISHED_DATE;