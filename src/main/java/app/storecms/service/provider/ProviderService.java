package app.storecms.service.provider;

import app.storecms.source.provider.Provider;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProviderService {
    private final Map<String, Provider> providers = new HashMap<>();
    public void registerProvider(Provider provider) {
        providers.put(provider.getProviderLabel(), provider);
    }
    public Map<String, Provider> getProviders() {
        return providers;
    }
}