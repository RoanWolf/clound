-- 创建数据库
CREATE DATABASE IF NOT EXISTS bm DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE bm;

-- 学生表
CREATE TABLE IF NOT EXISTS student (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '学生ID',
    name VARCHAR(50) NOT NULL COMMENT '学生姓名',
    age INT NOT NULL COMMENT '学生年龄'
) COMMENT '学生表';

-- 书籍表
CREATE TABLE IF NOT EXISTS book (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '书籍ID',
    name VARCHAR(100) NOT NULL COMMENT '书名',
    description TEXT COMMENT '书籍简介'
) COMMENT '书籍表';

-- 借阅表
CREATE TABLE IF NOT EXISTS borrow (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '借阅ID',
    student_id BIGINT NOT NULL COMMENT '学生ID',
    book_id BIGINT NOT NULL COMMENT '书籍ID',
    INDEX idx_student_book (student_id, book_id)
) COMMENT '借阅表';

-- ========== 插入数据 ==========

-- 学生数据
INSERT INTO student (name, age) VALUES
('张三', 20),
('李四', 22),
('王五', 21),
('赵六', 23),
('孙七', 19);

-- 书籍数据
INSERT INTO book (name, description) VALUES
('深入理解Java虚拟机', '全面解析JVM内存管理、类加载机制、性能调优等核心技术'),
('Spring实战', 'Spring框架入门与进阶，涵盖IoC、AOP、数据访问等核心模块'),
('MySQL必知必会', '从基础SQL到索引优化、事务隔离，数据库工程师必备'),
('算法导论', '系统讲解数据结构与经典算法，适合夯实编程基础'),
('设计模式之禅', '以生动案例讲解23种设计模式及其在实际项目中的应用'),
('重构：改善既有代码的设计', '教你如何识别代码坏味道，安全高效地重构遗留系统');

-- 借阅数据
INSERT INTO borrow (student_id, book_id) VALUES
(1, 1),  -- 张三借了 Java虚拟机
(1, 3),  -- 张三借了 MySQL必知必会
(2, 2),  -- 李四借了 Spring实战
(2, 5),  -- 李四借了 设计模式之禅
(3, 4),  -- 王五借了 算法导论
(4, 6),  -- 赵六借了 重构
(5, 1),  -- 孙七借了 Java虚拟机
(5, 2);  -- 孙七借了 Spring实战
