# varchar的特殊
> char(n)和varchar(n)都表示最大存储字符数，只是在是否保留尾部空间方面有所不同。 char长度可以是0到255之间的任何值。当存储CHAR值时，他们用制定长度的空格进行右填充。
> VARCHAR(N)长度范围为0-65535, varchar存储为1字节或2字节的长度前缀+数据。 如果不超过255个字节， 则使用一个长度字节。 存储varchar值时不进行填充。 根据标准SQL存储和检索值时， 将保留尾随空间。
> char(4)存储的时候始终是4个字节， 而varchar(4)存储'ab'的时候会使用3字节，因为第一个字节用来存储长度大小。