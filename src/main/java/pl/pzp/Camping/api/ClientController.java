package pl.pzp.Camping.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.pzp.Camping.model.Client;
import pl.pzp.Camping.service.ClientService;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/client")

@RestController
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public void addClient(@RequestBody Client client) {
        clientService.addClient(client);
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping(path = "{id}")
    public Client getClientById(@PathVariable("id") UUID id) {
        return clientService.getClientById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteClientById(@PathVariable("id") UUID id) {
        clientService.deleteClientById(id);
    }

    public void clientToUpdateById(@PathVariable("id") UUID id,@RequestBody Client clientToUpdate ) {
        clientService.updateClientById(id, clientToUpdate);
    }

}
