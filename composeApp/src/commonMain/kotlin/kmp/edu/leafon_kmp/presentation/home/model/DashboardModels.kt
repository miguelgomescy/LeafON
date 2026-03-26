package kmp.edu.leafon_kmp.presentation.home.model

// ─────────────────────────────────────────────────────────────────────────────
// DashboardModels.kt
//
// Modelos de estado da UI (camada de apresentação).
//
// IMPORTANTE: esses data classes representam o que a tela *precisa exibir*,
// não o que a API retorna. Quando você criar o ViewModel/Repository, haverá
// uma camada de mapeamento entre os DTOs do backend e esses modelos.
// Isso protege a UI de mudanças no contrato da API.
// ─────────────────────────────────────────────────────────────────────────────

/**
 * Estado completo da tela de Dashboard.
 * Um único objeto de estado é mais fácil de gerenciar no ViewModel
 * e evita recomposições parciais desnecessárias.
 */
data class DashboardUiState(
    val plantStatus: PlantStatusUi = PlantStatusUi(),
    val metrics: List<MetricUi> = emptyList(),
    val automationSummary: AutomationSummaryUi = AutomationSummaryUi(),
    val recentIrrigations: List<IrrigationUi> = emptyList(),
    val recentAlerts: List<AlertUi> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
)

/**
 * Dados do card hero — planta principal selecionada pelo usuário.
 * [deviceOnline] controla a badge "Online/Offline" na TopBar.
 */
data class PlantStatusUi(
    val name: String = "",
    val healthStatus: String = "",
    val soilHumidity: Int = 0,
    val lastUpdate: String = "",
    val deviceOnline: Boolean = false,
)

/**
 * Card de métrica genérico — reutilizado para Temperatura, Umidade e Luz.
 * Mantendo [label], [value] e [unit] separados facilitamos formatação
 * tipográfica diferenciada (valor maior que a unidade, por exemplo).
 */
data class MetricUi(
    val label: String = "",
    val value: String = "",
    val unit: String = "",
)

/** Resumo da configuração de automação do SmartPot. */
data class AutomationSummaryUi(
    val mode: String = "",
    val nextWatering: String = "",
    val humidityThreshold: Int = 0,
    val durationSeconds: Int = 0,
)

/** Evento de irrigação individual exibido na lista recente. */
data class IrrigationUi(
    val timestamp: String = "",
    val type: String = "",  // "Manual" | "Auto" | "Routine"
)

/**
 * Alerta gerado pelo sistema.
 * [level] determina a cor do ícone/badge na lista.
 */
data class AlertUi(
    val message: String = "",
    val timestamp: String = "",
    val level: AlertLevel = AlertLevel.INFO,
)

/** Enum para os três níveis de severidade de alerta. */
enum class AlertLevel { INFO, WARNING, CRITICAL }

// ── Dados de preview (usados apenas nos @Preview, nunca em produção) ──────────

/** Retorna um [DashboardUiState] preenchido para uso em Previews. */
fun dashboardPreviewState() = DashboardUiState(
    plantStatus = PlantStatusUi(
        name = "Aloe Vera",
        healthStatus = "Healthy",
        soilHumidity = 28,
        lastUpdate = "5 mins ago",
        deviceOnline = true,
    ),
    metrics = listOf(
        MetricUi("Temperature", "24", "°C"),
        MetricUi("Soil Humidity", "28", "%"),
        MetricUi("Light Level", "3,200", "lux"),
    ),
    automationSummary = AutomationSummaryUi(
        mode = "Automatic",
        nextWatering = "3:00 PM",
        humidityThreshold = 30,
        durationSeconds = 20,
    ),
    recentIrrigations = listOf(
        IrrigationUi("Today - 10:15 AM", "Auto"),
        IrrigationUi("Yesterday - 5:30 PM", "Manual"),
        IrrigationUi("Apr 14 - 8:00 AM", "Routine"),
    ),
    recentAlerts = listOf(
        AlertUi("Low Soil Humidity", "Today, 8:45 AM", AlertLevel.CRITICAL),
        AlertUi("High Temperature", "Apr 16, 2:10 PM", AlertLevel.WARNING),
    ),
)
