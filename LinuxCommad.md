<!-- MarkdownTOC -->

- [文件和目录](#文件和目录)
    - [cd](#cd)
    - [pwd](#pwd)
    - [ls](#ls)
    - [du](#du)
    - [file](#file)
    - [mkdir](#mkdir)
    - [touch](#touch)
    - [stat](#stat)
    - [echo](#echo)
    - [rm](#rm)
    - [mv](#mv)
    - [cp](#cp)
    - [ln](#ln)
- [文件查找](#文件查找)
    - [locate](#locate)
    - [find](#find)
    - [grep](#grep)
    - [which java](#which-java)
    - [whereis java](#whereis-java)
- [查看文件的内容](#查看文件的内容)
- [文本处理](#文本处理)
    - [ls](#ls-1)
    - [cat file1 >> file](#cat-file1--file)
- [压缩、解压](#压缩、解压)
    - [file 文件名](#file-文件名)
    - [tar](#tar)
    - [unzip a.zip](#unzip-azip)
    - [zip -r c.zip ./a/**](#zip--r-czip-a)
- [进程操作](#进程操作)
    - [ps](#ps)
    - [top](#top)
    - [kill](#kill)
- [运行其他程序](#运行其他程序)
    - [运行 jar 包](#运行-jar-包)
    - [运行 java](#运行-java)
        - [编译](#编译)
        - [执行](#执行)
    - [运行 python](#运行-python)
        - [习惯](#习惯)
        - [执行](#执行-1)

<!-- /MarkdownTOC -->


<a id="文件和目录"></a>
# 文件和目录

<a id="cd"></a>
## cd
Change Directory，用来切换工作目录，`语法：cd 相对或绝对路径或特殊符号`
> **cd**：进入该用户的主目录（root用户为/root,其他用户为/home/用户名）  
> **cd ..** ：返回上一级目录（注意要空格）  
> **cd -** ：返回上次所在目录  
> **cd /** ：返回根目录（绝对路径）  
> **cd ./目录1/目录2** ：进入当前目录下的子目录（相对路径）  

<a id="pwd"></a>
## pwd
Print Working Directory，显示工作路径

<a id="ls"></a>
## ls
List的缩写，用于列出目录下的文件，语法：`ls 选项 目录或文件名`
> **ls -a**：列出文件下所有的文件，包括以“.“开头的隐藏文  
> **ls -lh \*.log**：列出文件的详细信息（.log结尾，\*为通配符代表任意多个字符）


<a id="du"></a>
## du
用于查看使用空间，语法：`du 选项 目录或文件名（可多个）`
> **du -s dir1**： 显示dir1所有文件所占空间总和  
> **du -h dir1**：方便阅读的格式显示（有单位K，M等）
> **du -h  --max-depth=1**： 输出当前目录下各个子目录所使用的空间


<a id="file"></a>
## file
显示文件的类型（目录、text、zip、shell脚本等，可查看文件编码格式）`语法：file 文件或目录`

<a id="mkdir"></a>
## mkdir
创建目录，`语法：mkdir [-p] dirName`，-p确保目录名称存在，不存在的就建一个。
> **mkdir dir1**：创建目录(dir1)（mkdir为make directory的缩写）  
> **mkdir -p ./dir1/dir2**：递归创建目录（\-p：父目录不存在时，同时建立）

<a id="touch"></a>
## touch
创建文件touch a.txt，`语法：touch 文件名称`

<a id="stat"></a>
## stat
查看文件或文件夹的信息（包括创建人、大小等）`语法：stat 文件（夹）名`
* stat dir
* stat a.txt

<a id="echo"></a>
## echo 
echo "linux" >> hello.txt**：输出到文件

<a id="rm"></a>
## rm
* 可以删除一个目录中的一个或多个文件或目录，也可以将某个目录及其下属的所有文件及子目录均删除掉
* `语法：rm 选项 文件名或目录`（注：如果参数中含有目录，则必须加上-r选项）
> **rm 文件**：删除文件  
> **rm -r 目录或文件**：删除目录（及目录下所有文件）（非空也可以）  
> **rm -rf 目录或文件**：强制删除，如：rm -rf * 为删除当前目录下所有文件  
> **find -inum 1842601 -exec rm -rf {} ;** ：删除乱码文件或目录(会提示找不到此文件或文件夹但其实已经删除了)（先使用ls -inum命令找到inode，即文件或目录前面的数字字符串,如1842601，然后使用删除操作注意{}与;之间的空格）

<a id="mv"></a>
## mv
* move的缩写，可以用来剪切移动文件、目录或者将文件改名
* `语法：mv 源文件 目标文件（改名）或目录（移动）`
> **mv a b**：移动或者重命名一个文件或者目录（存在即移动目录或覆盖文件，不存在即改名）  
> **mv /opt/git/g /opt/a** ：移动g到opt目录下并改名为a（a目录不存在，若存在则为移动g到a目录下）  
> **mv -t ./test a.txt b.txt** ：移动多个文件到某目录下(-t 选项适用于移动多个源文件到一个目录的情况，此时目标目录在前，源文件在后)

<a id="cp"></a>
## cp
复制文件或目录；cp命令可以将单个或多个文件复制到一个已经存在的目录下
> 常用：cp -ai 文件或目录 目标目录;  
> **cp file1.txt dir2/file2.txt**：将 file1.txt 移动到文件夹 dir2 下，并重命名为 file2.txt
> **cp -ai /opt/abc /opt/git/**：复制abc目录（或文件）到git目录下（选项a表示文件的属性也复制，目录下所有文件都复制；i表示覆盖前询问）  
> **cp  -r dir2/\*.txt dir2/dir3**：复制dir2文件夹下面的所有txt文件到dir2/dir3目录，r表示复制目录及目录内的所有项目

<a id="ln"></a>
## ln
link的缩写，用于建立硬（软）链接，常用于软件安装时建软链接(类似快捷方式)到PATH，-s表示软链接  
`语法：ln -s 源文件 目标文件`
> **ln -s /opt/a.txt /opt/git/**：对文件创建软链接（快捷方式不改名还是a.txt）  
> **ln -s /opt/a.txt /opt/git/b**：（快捷方式改名为b）（下面的一样可以改名）  
> **ln -s /opt/mulu /opt/git/**：对目录创建软链接  
> **ln /opt/a.txt /opt/git/**：对文件创建硬链接

<a id="文件查找"></a>
# 文件查找
<a id="locate"></a>
## locate
locate a.txt 在系统全局范围内查找文件名包含a.txt字样的文件（比find快）
> locate原理是updatedb会把文件系统中的信息存放到数据库databases中（但一般一天才执行一次，所以locate找不到新创建的文件，需要先手动执行updatedb，再执行locate）,locate从数据库中读数据

<a id="find"></a>
## find
在目录结构中搜索文件，并执行指定的操作，`语法：find path -option`
> **find /home -mtime -2**：在/home下查最近2\*24小时内改动过的文件  
> **find . -size +100M**：在当前目录及子目录下查找大于100M的文件  
> **find . -mtime +2 -exec rm {} ;**：查出更改时间在2\*24小时以前的文件并删除它
> **find . -name \*.log -exec grep -i hello {} ; -print**：在当前目录及子目录下查出文件名后缀为.log的文件并且该文件内容包含了hello字样并打印，-exec 命令表示对查出文件操作，-i表示不区分大小写  
> **find . -name \*.log | grep hello**：在当前目录及子目录下查出文件名后缀为.log的文件并且文件名包含了hello字样（grep用来处理字符串）

<a id="grep"></a>
## grep
全面搜索正则表达式并把行打印出来，`语法：grep -option regex filename`
> 默认区分大小写，-i 选项可以忽略大小写
> **grep match_word file_name**：在文件中搜索一个单词，命令会返回一个包含“match_word”的文本行  
> **grep -v match_word file_name**：在文件中搜索一个单词，命令会返回一个不包含“match_word”的文本行  
> **grep -c match_word file_name**：统计文件中包含“match_pattern”的文本行的行数  
> **grep match_word -n file_name**：在文件中搜索一个单词，输出包含“match_pattern”的文本行并标出行数

<a id="which-java"></a>
## which java
在环境变量PATH设置的目录里查找符合条件的文件，并显示路径（查询运行文件所在路径）  

<a id="whereis-java"></a>
## whereis java
查看安装的软件的所有的文件路径（whereis 只能用于查找二进制文件、源代码文件和man手册页，一般文件的定位需使用locate命令）

<a id="查看文件的内容"></a>
# 查看文件的内容
**cat -n 文件名**：显示文件内容，连行号一起显示  
**cat filename | grep abc -A10**：查看filename中含有abc所在行后10行（A10）  
**less 文件名**：一页一页的显示文件内容（搜索翻页同man命令）  
**head -n 文件名**：显示文件头n行内容，n指定显示多少行
**tail -nf 文件名**：显示文件尾几行内容,n指定显示多少行,f用于实时追踪文件的所有更新，常用于查阅正在改变的日志文件（如tail -f -n 3 a.log 表示开始显示最后3行，并在文件更新时实时追加显示，没有\-n默认10行）

<a id="文本处理"></a>
# 文本处理
<a id="ls-1"></a>
## ls
> **ls -l > file**: ls -l命令结果输出到file文件中，若存在，则覆盖  
> **ls fileno 2>file**：2>表示重定向标准错误输出（文件不存在，报错信息保存至file文件）

<a id="cat-file1--file"></a>
## cat file1 >> file
输出重定向之cat命令结果输出追加到file文件(>表示覆盖原文件内容，>>表示追加内容)  

<a id="压缩、解压"></a>
# 压缩、解压
<a id="file-文件名"></a>
## file 文件名
查文件类型（可看是用哪一种方式压缩的）

<a id="tar"></a>
## tar
> **tar -zxvf a.tar.gz -C ./test**：解压tar.gz到当前目录下的test目录  
> **tar -zcvf /opt/c.tar.gz ./a/**：压缩tar.gz（把a目录及目录下所有文件压缩为 /opt/目录下的c.tar.gz  
> **tar -jxvf a.tar.bz2**：解压tar.bz2到当前目录  
> **tar -jcvf c.tar.bz2 ./a/**：压缩tar.bz2（把a目录及目录下所有文件压缩到当前目录下为c.tar.gz2）  

<a id="unzip-azip"></a>
## unzip a.zip
解压zip（到当前目录）  

<a id="zip--r-czip-a"></a>
## zip -r c.zip ./a/**
压缩zip(把a目录及目录下所有文件压缩到当前目录下为c.zip）

<a id="进程操作"></a>
# 进程操作
<a id="ps"></a>
## ps
用于显示当前进程 (process) 的状态，语法`ps [options] [--help]`
> **ps -A**：显示所有进程信息  
> **ps -S**：显示进程状态
> > D: Uninterruptible sleep (usually IO)  
> > R: Running or runnable (on run queue)  
> > S: Interruptible sleep (waiting for an event to complete)  
> > T: Stopped, either by a job control signal  
> > X: dead (should never be seen)  
> > Z: Defunct ("zombie") process, terminated but not reaped by its parent  
> > s: stands for session leader  
> > +: tells it runs in foreground

> **ps -ef**：显示所有命令，连带命令行  
> **ps -u username**：显示指定用户的进程信息  
> **ps aux --sort=rss**：显示所有进程信息，按内存升序排列  
> **ps aux --sort=-%cpu**：显示所有进程信息，按CPU降序排列  
> **pstree -p**：以树的形式展示进程，-p 选项可以现实 pid  
> 

<a id="top"></a>
## top
实时显示进程的动态
> **top -p 139**：显示进程号为139的进程信息，CPU、内存占用率等  
> **top -n 5**：显示5个进程  

<a id="kill"></a>
## kill
实时显示进程的动态
> **kill 139**：杀死进程号为139的进程  
> **kill -9 139**：彻底杀死进程号为139的进程  
> **kill -u username 或者 kill -9 $(ps -ef | grep username)**：杀死指定用户的所有进程  


<a id="运行其他程序"></a>
# 运行其他程序
<a id="运行-jar-包"></a>
## 运行 jar 包
* java -jar XXX.jar
    - 最基本的jar包执行方式，但当用 ctrl+c 中断或者关闭窗口时，程序也会中断执行

* java -jar XXX.jar &
    - & 代表在后台运行，使用 ctrl+c 不会中断程序的运行，但是关闭窗口会中断程序的运行

* nohup java -jar XXX.jar &
    - nohup 表示程序不被挂起，使用 ctrl+c 中断或者关闭窗口都不会中断程序的执行，程序日志会默认输出到当前目录下的 nohup.out 文件

* nohup java -jar XXX.jar >temp.out &
    - temp.out的意思是将日志输出重定向到 temp.out 文件，使用 ctrl+c 中断或者关闭窗口都不会中断程序的执行

* nohup java -jar XXX.jar >temp.out 2>&1 &
    - 第一个 > 会覆盖 temp.out 的原有内容，如果使用 >> 则追加内容
    - 0 标准输入（一般是键盘）
    - 1 标准输出（一般是显示屏，准确的说是用户终端控制台）
    - 2 标准错误（出错信息输出）
    - 2>&1 就是用来将标准错误 2 重定向到标准输出 1 中的
    - 此处 1 前面的 & 就是为了让 bash 将 1 解释成标准输出而不是文件 1
    - 最后一个 & ，则是让 bash 在后台执行

* &, nohup, >, >>, 2>&1 等命令也适用于 java python 文件的运行

<a id="运行-java"></a>
## 运行 java
<a id="编译"></a>
### 编译
javac javaFilePath.java -d 生成的class文件要存放的位置（假设为 .bin/）

* 如果有依赖jar包需要引入，多个用**:**隔开，如：javac -cp /tmp/test/lib/commons-codec-1.4.jar:/tmp/test/lib/commons-httpclient-3.1.jar /tmp/test/src/test.java

<a id="执行"></a>
### 执行
java -cp ./bin javaFilePath

* -cp 表示classpath，后跟路径
* 有依赖包的例子：java -cp /tmp/test/lib/commons-codec-1.4.jar:/tmp/test/lib/commons-httpclient-3.1.jar:/tmp/test/src/ test

<a id="运行-python"></a>
## 运行 python
<a id="习惯"></a>
### 习惯
代码前添加：
```Python
#!/usr/bin/env python3
# -*- coding:utf-8 -*-
```

<a id="执行-1"></a>
### 执行
nuhup python -u test.py > test.log 2>&1 &

* -u 表示不启用缓存，实时输出打印信息到日志文件，也可不使用该选项
* 其他输出设置类似于 jar 包的运行


