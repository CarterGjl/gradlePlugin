import org.gradle.api.Plugin
import org.gradle.api.Project

class PublishAppPlugin implements Plugin<Project>{

    @Override
    void apply(Project target) {
//        入口
        target.extensions.create("publishAppInfo",PublishAppInfoExtension.class)
        target.tasks.create("publishApp",PublishAppTask.class)
    }
}