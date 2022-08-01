package app.storecms.service.provider;

import app.storecms.source.provider.Provider;

import java.util.List;
import java.util.Map;

public interface ProviderService {
    void registerProvider(Provider provider);
    Map<String, Provider> getProviders();
    List<String> getProviderLabels();
    Provider getProviderByLabel(String label);
}