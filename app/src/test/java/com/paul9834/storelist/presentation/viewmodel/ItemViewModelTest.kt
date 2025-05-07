package com.paul9834.storelist.presentation.viewmodel

import com.paul9834.storelist.data.model.ItemModel
import com.paul9834.storelist.domain.repository.ItemsRepository
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ItemViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private val testScope = TestScope(testDispatcher)

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `init is called, items are loaded`() = testScope.runTest {
        val fakeItems = listOf(
            ItemModel(id = 1, title = "Shoe", description = "Nike One"),
            ItemModel(id = 2, title = "Monitor", description = "Monitor 144hz")
        )

        val fakeRepo = object : ItemsRepository {
            override suspend fun getProducts(): List<ItemModel> = fakeItems
        }

        val vm = ItemViewModel(repository = fakeRepo)

        testDispatcher.scheduler.advanceUntilIdle()

        assertEquals(fakeItems, vm.items.value)
    }

    @Test
    fun `When repo fails, items remain empty and do not crash`() = testScope.runTest {

        val failingRepo = object : ItemsRepository {
            override suspend fun getProducts(): List<ItemModel> =
                throw RuntimeException("Network failure")
        }

        val vm = ItemViewModel(repository = failingRepo)

        testDispatcher.scheduler.advanceUntilIdle()

        assertTrue("The list must remain empty after the ruling", vm.items.value.isEmpty())
    }
}