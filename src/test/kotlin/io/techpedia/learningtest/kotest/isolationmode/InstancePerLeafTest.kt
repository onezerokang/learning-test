package io.techpedia.learningtest.kotest.isolationmode

import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import java.util.concurrent.atomic.AtomicInteger

class InstancePerLeafTest : FreeSpec({
    isolationMode = IsolationMode.InstancePerLeaf
    val callCount = AtomicInteger()

    "Root test case1" - {
        println("Root1")
        callCount.incrementAndGet() shouldBe 1
        "Leaf test case1" {
            println("Leaf1")
            callCount.incrementAndGet() shouldBe 2
        }

        "Leaf test case2" {
            println("Leaf2")
            callCount.incrementAndGet() shouldBe 2
        }
    }

    "Root test case2" - {
        println("Root2")
        callCount.incrementAndGet() shouldBe 1
        "Leaf test case3" {
            println("Leaf3")
            callCount.incrementAndGet() shouldBe 2
        }
    }
})
