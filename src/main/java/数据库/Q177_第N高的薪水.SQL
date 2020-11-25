-- 编写一个 SQL 查询，获取 Employee 表中第 n 高的薪水（Salary）。
--
-- +----+--------+
-- | Id | Salary |
-- +----+--------+
-- | 1  | 100    |
-- | 2  | 200    |
-- | 3  | 300    |
-- +----+--------+
-- 例如上述 Employee 表，n = 2 时，应返回第二高的薪水 200。如果不存在第 n 高的薪水，那么查询应返回 null。
--
-- +------------------------+
-- | getNthHighestSalary(2) |
-- +------------------------+
-- | 200                    |
-- +------------------------+

-- 第一次： 错误原因：limit不支持运算
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      select(select distinct salary from Employee order by Salary desc limit N-1,1)
  );
END

-- 第二次:
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
DECLARE x INT DEFAULT 0;
set x=N-1;              -- 这两句直接优化成 set N = N-1;
  RETURN (
      # Write your MySQL query statement below.
      --select(select distinct salary from Employee order by Salary desc limit x,1)
      select distinct salary from Employee order by Salary desc limit x,1
  );
END