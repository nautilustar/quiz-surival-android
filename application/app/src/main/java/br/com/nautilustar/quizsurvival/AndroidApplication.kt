package br.com.nautilustar.quizsurvival

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import br.com.nautilustar.core.base.Injectable
import br.com.nautilustar.quizsurvival.di.AppComponent
import br.com.nautilustar.quizsurvival.di.DaggerAppComponent
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import io.realm.Realm
import javax.inject.Inject

class AndroidApplication : Application(),
    HasActivityInjector,
    Application.ActivityLifecycleCallbacks {

    @Inject
    lateinit var dispatchingActivityAndroidInjector: DispatchingAndroidInjector<Activity>

    private lateinit var appComponent: AppComponent

    init {
        registerActivityLifecycleCallbacks(this)
    }

    override fun onCreate() {
        super.onCreate()
        setupDagger()
        setupRealm()
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingActivityAndroidInjector
    override fun onActivityCreated(activity: Activity?, p1: Bundle?) = handleActivity(activity)
    override fun onActivityPaused(p0: Activity?) {}
    override fun onActivityResumed(p0: Activity?) {}
    override fun onActivityStarted(p0: Activity?) {}
    override fun onActivityDestroyed(p0: Activity?) {}
    override fun onActivitySaveInstanceState(p0: Activity?, p1: Bundle?) {}
    override fun onActivityStopped(p0: Activity?) {}

    private fun createComponent(): AppComponent {
        val dagger = DaggerAppComponent
            .builder()
            .application(this)

        return dagger.build()
    }

    private fun setupDagger() {
        appComponent = createComponent().apply {
            inject(this@AndroidApplication)
        }
    }

    private fun setupRealm() {
        Realm.init(this)
    }

    private fun handleActivity(activity: Activity?) {
        if (activity is HasSupportFragmentInjector) {
            AndroidInjection.inject(activity)
        }

        if (activity is FragmentActivity) {
            activity.supportFragmentManager
                .registerFragmentLifecycleCallbacks(object : FragmentManager.FragmentLifecycleCallbacks() {
                    override fun onFragmentCreated(fm: FragmentManager, f: Fragment, savedInstanceState: Bundle?) {
                        if (f is Injectable) {
                            AndroidSupportInjection.inject(f)
                        }
                    }
                }, true)
        }
    }
}