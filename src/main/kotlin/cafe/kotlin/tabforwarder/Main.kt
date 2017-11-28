package cafe.kotlin.tabforwarder

external val browser: dynamic

fun main(arguments: Array<String>) {
    console.log("Hello, Firefox Quantum!")

    browser.tabs.onCreated.addListener { tab: dynamic ->
        if (tab.openerTabId == null) {
            console.log("Unknown origin of tab: assuming other device, showing...")

            browser.tabs.update(tab.id, object : Any() {
                val active = true
            })
        }
    }
}
