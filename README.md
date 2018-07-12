
[![](https://img.shields.io/badge/python-3.4-green.svg)](https://www.python.org/download/releases/3.4.0/) [![](https://img.shields.io/badge/python-3.5-green.svg)](https://www.python.org/downloads/release/python-352/)
[![](https://img.shields.io/badge/python-3.6-green.svg)](https://www.python.org/downloads/release/python-360/) [![](https://img.shields.io/badge/license-MIT-brightgreen.svg)](LICENSE)

一站式IT管理系统，包含持续集成、监控、服务器自动化部署，打通开发、运维、测试的边界。为中小企业的IT管理保驾护航。



### 代码风格建议

- 使用类视图代替函数视图
- 使用form来验证表单

### 本地运行开发环境

#### 安装依赖

```sh
git clone https://github.com/itpubs/OneStack.git
cd OneStack

# 安装Python依赖
python3 -m venv venv
source venv/bin/activate

# 执行数据库迁移
./manage.py makemigrations
./manage.py migrate

# 安装前端依赖(不要使用npm)
yarn install
```

#### 运行

```sh
./manage.py runserver
```

### 部署到生产环境

- 建议部署在安全的内网环境，外网使用建议使用VPN。
