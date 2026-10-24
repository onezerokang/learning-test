package io.techpedia.learningtest.kotest.isolationmode

import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import java.util.concurrent.atomic.AtomicInteger

class InstancePerRootTest : FreeSpec({
    isolationMode = IsolationMode.InstancePerRoot
    val callCount = AtomicInteger()

    "Root test case1" - {
        callCount.incrementAndGet() shouldBe 1
        "Leaf test case1" {
            callCount.incrementAndGet() shouldBe 2
        }

        "Leaf test case2" {
            callCount.incrementAndGet() shouldBe 3
        }
    }

    "Root test case2" - {
        callCount.incrementAndGet() shouldBe 1
        "Leaf test case3" {
            callCount.incrementAndGet() shouldBe 2
        }
    }
})
