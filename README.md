![image](https://user-images.githubusercontent.com/49310928/179914663-1e5e57ff-930f-4857-b349-38bfb4d73a49.png)
实体层，这里其实就是我们平时定义的一些 Bean 的实体类，用 Kotlin 的数据类即可
数据层，这里一般会有两个概念，分别是 DataSource 与 Repository，前者代表数据源，后者代表数据仓库。数据源一般会区分本地数据源和远程数据源，而数据仓库则会统筹它们两者
领域层，这里一般会是一些相对具体一些的业务逻辑
表现层，这里则是接近 UI 展示的上层逻辑了

实体层
ResultX密封类：统一不同情况下返回的数据形式
RepoList
Repo

数据层
首先RepoDataSource 和 Repository定义相关接口
定义RetrofitClient 用来请求 API
RemoteRepoDataSource数据层-处理远程数据源
MainRepository数据仓库：用于统筹缓存数据、远程数据
RetrofitClient数据层-具体网络请求API实现类
RepoService数据层-网络请求API

领域层
GetRepoListUseCase领域层：业务逻辑的一个小单元

表现层
MainViewModel 表现层-ViewModel
