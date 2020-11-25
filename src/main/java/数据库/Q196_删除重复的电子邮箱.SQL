-- 编写一个 SQL 查询，来删除 Person 表中所有重复的电子邮箱，重复的邮箱里只保留 Id 最小 的那个。
-- +----+------------------+
-- | Id | Email            |
-- +----+------------------+
-- | 1  | john@example.com |
-- | 2  | bob@example.com  |
-- | 3  | john@example.com |
-- +----+------------------+
-- Id 是这个表的主键。
-- 例如，在运行你的查询语句之后，上面的 Person 表应返回以下几行:
-- +----+------------------+
-- | Id | Email            |
-- +----+------------------+
-- | 1  | john@example.com |
-- | 2  | bob@example.com  |
-- +----+------------------+
--  
-- 第一次： 读错题了，题目是让删除，不是找出来
select Id,Email from Person group by Email

-- 第二次： 错误原因
-- 对SQL语法理解不到位，delete方法中并不能缓存select子查询查出的语句；
-- 如果想使用这种方法，应该用后面的语法
DELETE FROM q196
 WHERE id NOT IN (
 SELECT id FROM q196 GROUP BY email)
 )

DELETE from Person
Where Id not in (
    Select Id
    From(
    Select MIN(Id) as id
    From Person
    Group by Email
   ) t
)


-- 第三次：官方答案，使用自联结  注意delete中的表别名问题
DELETE p1 FROM Person p1,
    Person p2
WHERE
    p1.Email = p2.Email AND p1.Id > p2.Id



