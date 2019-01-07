import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class PublishAppTask extends DefaultTask {

    PublishAppTask() {
        group="carter"
        dependsOn "build"
    }
    @TaskAction
    void doAction(){
//打包已经完成
        def oldApkPath = "${project.getBuildDir()}/outputs/apk/release/app-release.apk"

        //获取参数
        def qihuPath = project.extensions.publishAppInfo.qihuPath
        def keyStorePath = project.extensions.publishAppInfo.keyStorePath
        def keyStorePwd = project.extensions.publishAppInfo.keyStorePwd
        def keyStoreKeyAlias = project.extensions.publishAppInfo.keyStoreKeyAlias
        def keyStoreKeyAliasPwd = project.extensions.publishAppInfo.keyStoreKeyAliasPwd
        def apkOutputDir = project.extensions.publishAppInfo.outputPath

        execCmd("java -jar ${qihuPath} -login userName pwd")
        //360加固-签名信息配置
        execCmd("java -jar ${qihuPath}  -importsign ${keyStorePath} ${keyStorePwd} ${keyStoreKeyAlias} " +
                "${keyStoreKeyAliasPwd}")
        //360加固-渠道信息配置
        execCmd("java -jar ${qihuPath} -importmulpkg ${project.extensions.publishAppInfo.channelPath}")
        //360加固-开始加固
        execCmd("java -jar ${qihuPath} -jiagu ${oldApkPath} ${apkOutputDir} -autosign  -automulpkg")
        println "加固完成"
    }

    void execCmd(cmd){
        project.exec {
            executable 'bash'
            args '-c', cmd
        }
    }
}