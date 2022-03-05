一、Git的使用

1、不同分支都和合到远程主分支上
在本地创建一个分支A，命令:git push origin A  会在远程生成一个分支A，然后把本地A分支的内容推上去。
也可以用命令：git push origin A:master   把本地A分支的内容推到远程master上。
命令：git push --set-upstream origin A可以将本地A分支与远程A分支关联起来，第一次的话会把内容推上去，关联之后
每次推送只要执行 git push 即可
删除远程分支的命令：  git push origin --delete 分支名

2、创建远程仓库
先在github上创建一个新的仓库，如Notes
然后把本地的仓库与之关联，执行命令$ git remote add origin git@github.com:153572045/Notes.git
其中origin是默认远程库的名字，也可以用其他的，但是该远程仓库被其他人拉下来之后名字默认也是origin。

之后执行命令: git push -u origin master  把本地库推到远程，由于是第一次推送，所以加-u参数可以把本地库的mster分支和
远程库的master分支关联起来，下次执行git push 就可以直接推送了，类似于上面的（--set-upstream） 

3、克隆远程库到本地
命令：$ git clone git@github.com:153572045/Notes.git
克隆之后远程库的名字默认是origin，不管第一次推上去的时候命名为啥


二、知识点地址
https://blog.csdn.net/v123411739/article/details/78996181   hashmap学习

