# Lista de Productos StoreList (MVVM Clean Arquitecture) / Prueba Kevin Paul Montealegre Melo / Grupo ASD
## Instrucciones para Correr el Proyecto 🚀:

![MVVM](https://i.imgur.com/qZ3uHOs.png)

1. Clona el repositorio:
2. git clone https://github.com/Paul9834/StoreList.git
3. Abre el proyecto en Android Studio
4. Sincroniza Gradle.
5. Conecta un dispositivo Android o inicia un emulador.
6. Ejecuta la aplicación:
   Desde Android Studio
   Run > Run "app"

## 📂 Estructura de Carpetas
```
com.paul9834.storelist
├── data
│   ├── api
│   │   ├ ApiService.kt
│   │   └ RetrofitInstance.kt
│   ├── model
│   │   ├ ItemModel.kt
│   │   └ RatingModel.kt
│   └── repository
│       └ DefaultItemsRepository.kt   ← Implementación concreta de ItemsRepository
│
├── domain
│   └── repository
│       └ ItemsRepository.kt          ← Interfaz del repositorio
│
└── presentation
    ├── navigation
    │   ├ MyAppNavigation.kt
    │   └ NavRoutes.kt                ← Definición de rutas de navegación
    ├── ui
    │   ├ screen
    │   │   ├ productlist
    │   │   │   ├ ItemCard.kt
    │   │   │   └ ItemListScreen.kt
    │   │   └ productdetail
    │   │       ├ ProductDetailScreen.kt
    │   │       └ ProductDetailCard.kt
    │   └ theme
    │       ├ Color.kt
    │       ├ Theme.kt
    │       └ Type.kt
    ├── viewmodel
    │   ├ ItemViewModel.kt            ← Lógica de estado de lista
    │   └ ItemViewModelFactory.kt     ← Fábrica para inyección manual
    └── MainActivity.kt               ← Entry point de la app
```


## Arquitectura 🏗️

- **MVVM + Clean Architecture**
   - *data*: implementaciones concretas (Retrofit, DTOs, repositorios)
   - *domain*: interfaz `ItemsRepository` 
   - *presentation*: ViewModels, UI (Compose) y navegación

- **Repository Pattern**
   - La interfaz `ItemsRepository` desacopla la lógica de presentación de los datos.
   - `DefaultItemsRepository` usa `RetrofitInstance.api.getProducts()`

- **Inyección manual**
   - Sin frameworks de DI: `ItemViewModelFactory` pasa el repositorio al ViewModel.
   - En Compose: `viewModel(factory = ItemViewModelFactory(repo))`

- **Navegación con SavedStateHandle**
   - Se guarda y recupera `ItemModel` desde el estado de navegación
   - `NavRoutes.kt` define rutas: `"list"`, `"detail"`

- **Tests**
   - *Unitarias*: validan `ItemViewModel` para flujo exitoso y de error.
   - *Instrumentadas*: comprueban navegación con testTags y `performScrollTo()`

## Dependencias

Librerias usadas en el proyecto:

```kotlin
// ——— Pruebas ———
testImplementation(libs.junit)                         // allow to test code
testImplementation(libs.kotlinx.coroutines.test)       // allow to test coroutines

// ——— Carga de imágenes ———
implementation(libs.coil.compose)                      // allow load pics from servers
implementation(libs.coil.network.okhttp)

// ——— Arquitectura & Ciclo de vida ———
implementation(libs.androidx.lifecycle.viewmodel.compose) // allow to use viewmodel

// ——— Navegación ———
implementation(libs.androidx.navigation.compose)       // allow to navigate between screens

// ——— Serialización ———
implementation(libs.kotlinx.serialization.json)        // allow to serialize data

// ——— Comunicación con servidor ———
implementation(libs.retrofit)                          
implementation(libs.converter.gson)                    // allow to get data from server
```
---



> **Conclusión:** Esta arquitectura proporciona una estructura sólida, con separación de capas y repositorio, facilita la mantenibilidad, testabilidad y escalabilidad del proyecto.