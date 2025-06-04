import com.cosbell.spa.dto.HorarioRequest
import com.cosbell.spa.service.HorarioService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/horarios")
class HorarioController(private val horarioService: HorarioService) {

    @PostMapping
    fun crearHorario(@RequestBody request: HorarioRequest): Horario {
        return horarioService.crearHorario(request)
    }
}