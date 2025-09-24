-- 2022년 8월~10월 총 대여 횟수 5회 이상 자동차의 월별 대여 횟수 조회
WITH QualifiedCars AS (
    -- 1단계: 2022년 8월~10월 기간 동안 총 대여 횟수가 5회 이상인 자동차 찾기
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE START_DATE >= '2022-08-01' 
      AND START_DATE < '2022-11-01'
    GROUP BY CAR_ID
    HAVING COUNT(*) >= 5
),
MonthlyRecords AS (
    -- 2단계: 해당 자동차들의 월별 대여 횟수 계산
    SELECT 
        EXTRACT(MONTH FROM START_DATE) AS MONTH,
        CAR_ID,
        COUNT(*) AS RECORDS
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE CAR_ID IN (SELECT CAR_ID FROM QualifiedCars)
      AND START_DATE >= '2022-08-01' 
      AND START_DATE < '2022-11-01'
    GROUP BY EXTRACT(MONTH FROM START_DATE), CAR_ID
)
-- 3단계: 최종 결과 출력 (월 오름차순, 자동차 ID 내림차순)
SELECT MONTH, CAR_ID, RECORDS
FROM MonthlyRecords
ORDER BY MONTH ASC, CAR_ID DESC;