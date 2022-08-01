package app.storecms.service.provider;

import app.storecms.source.provider.Provider;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProviderServiceImpl implements ProviderService {
    private final Map<String, Provider> providers = new HashMap<>();
    public void registerProvider(Provider provider) {
        providers.put(provider.getProviderLabel(), provider);
    }
    public Map<String, Provider> getProviders() {
        return providers;
    }
    public List<String> getProviderLabels() {
        return providers.keySet().stream().toList();
    }
    public Provider getProviderByLabel(String label) {
        return providers.get(label);
    }
}