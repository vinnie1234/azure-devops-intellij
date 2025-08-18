# IntelliJ Platform Gradle Plugin 2.0 Migration Status

## Overview
This document tracks the migration progress from the old IntelliJ Gradle Plugin to the new IntelliJ Platform Gradle Plugin 2.0 for compatibility with IntelliJ IDEA 2025.2.

## Current Status: PARTIALLY COMPLETE ⚠️

### ✅ Completed Migrations
- **Build System**: Updated to IntelliJ Platform Gradle Plugin 2.7.2
- **Java Compatibility**: Upgraded from Java 17 to Java 21 (required for IDEA 2025.2)
- **Gradle Toolchain**: Configured automatic Java 21 toolchain provisioning
- **Plugin Configuration**: Migrated core `intellijPlatform` configuration blocks
- **Dependencies**: Updated IntelliJ platform and bundled plugin dependencies
- **GitHub Actions**: Updated workflow to use Java 21
- **Main Modules**: Successfully migrated `:plugin`, `:plugin:test-utils`, and `:L2Tests` modules

### ⏳ In Progress
- **Client Modules**: Partial migration of reactive backend modules

### ❌ Remaining Issues

#### 1. Client Module Compilation Errors
The plugin module depends on generated classes from client modules that are currently failing to compile:

**Affected Modules:**
- `:client:protocol` - RdGen plugin compatibility issues with Gradle 8.10+
- `:client:connector` - Missing generated model classes causing compilation failures  
- `:client:backend` - Needs `mainClassName` → `mainClass` migration for Gradle 8+
- `:client:backend:tfs-sdk` - Dependent on backend module fixes

**Compilation Errors:**
```
error: package com.microsoft.tfs.model.connector does not exist
import com.microsoft.tfs.model.connector.TfsLocalPath;
```

#### 2. RdGen Plugin Compatibility
- Current version: `2023.3.2` (latest working version found)
- Issue: The `com.jetbrains.rdgen` plugin has compatibility issues with Gradle 8.10+
- Impact: Cannot generate model classes needed by connector and plugin modules

#### 3. Custom Sandbox Tasks
- Legacy tasks `prepareBackendSandbox` are commented out
- Need to find correct property names for new plugin version
- Required for copying reactive backend to plugin sandbox

## Migration Steps Completed

### 1. Root Build Configuration
```gradle
plugins {
    id 'org.jetbrains.intellij.platform' version '2.7.2' apply false
    id 'org.jetbrains.kotlin.jvm' version '1.9.24' apply false
}
```

### 2. Plugin Module Migration
```gradle
project(":plugin") {
    apply plugin: 'org.jetbrains.intellij.platform'
    
    repositories {
        intellijPlatform {
            defaultRepositories()
        }
    }
    
    dependencies {
        intellijPlatform {
            intellijIdeaCommunity(ideaVersion)
            bundledPlugin('Git4Idea')
            bundledPlugin('com.intellij.java')
            
            pluginVerifier()
            zipSigner()
            instrumentationTools()
        }
    }
    
    intellijPlatform {
        pluginConfiguration {
            name = 'com.microsoft.vso.idea'
        }
        
        publishing {
            token = providers.environmentVariable("PUBLISH_TOKEN")
        }
        
        pluginVerification {
            ides {
                recommended()
            }
        }
    }
}
```

### 3. Java Toolchain Configuration
```gradle
configure(mainProjects + clientProjects) {
    java {
        toolchain {
            languageVersion = JavaLanguageVersion.of(21)
        }
    }
}
```

### 4. Settings Configuration
```gradle
plugins {
    id 'org.gradle.toolchains.foojay-resolver-convention' version '0.8.0'
}
```

## Next Steps to Complete Migration

### Phase 1: Fix RdGen Plugin
1. **Research newer RdGen versions** compatible with Gradle 8.10+
2. **Alternative**: Migrate to newer code generation approach
3. **Workaround**: Use pre-generated model files temporarily

### Phase 2: Client Module Dependencies
1. **Update backend module**: Fix `mainClassName` → `mainClass` migration
2. **Fix Kotlin targets**: Ensure all modules use JVM target 21
3. **Resolve dependency chains**: Ensure protocol → connector → plugin dependency flow works

### Phase 3: Custom Task Migration
1. **Identify correct property names** for sandbox tasks in new plugin version
2. **Update `prepareBackendSandbox` tasks** for both plugin and L2Tests modules
3. **Test sandbox preparation** with reactive backend

### Phase 4: Final Verification
1. **Full build test**: `./gradlew buildPlugin`
2. **Plugin verification**: Test with Plugin Verifier
3. **IDE compatibility**: Test with IntelliJ IDEA 2025.2

## Temporary Workarounds Applied

### Disabled Modules
Client modules are temporarily excluded from build:
```gradle
// settings.gradle
include "plugin", "plugin:test-utils", "L2Tests"
// Temporarily excluded: "client:backend", "client:backend:tfs-sdk", "client:connector", "client:protocol"
```

### Disabled Dependencies
```gradle
// build.gradle - plugin module
dependencies {
    // Temporarily disabled:
    // implementation project(path: ":client:connector", configuration: "default")
}
```

## Key Configuration Changes

| Component | Old Version | New Version | Status |
|-----------|-------------|-------------|---------|
| IntelliJ Plugin | org.jetbrains.intellij | org.jetbrains.intellij.platform 2.7.2 | ✅ |
| Java Target | 17 | 21 | ✅ |
| Kotlin JVM Target | 11 | 21 | ✅ |
| Kotlin Version | 1.4.31 | 1.9.24 | ✅ |
| Gradle Version | 8.10 | 8.10 | ✅ |
| RdGen Version | 2021.3.0 | 2023.3.2 | ⚠️ |

## Testing Commands

```bash
# Test main plugin module (currently working)
./gradlew :plugin:tasks --group="intellij platform"

# Test full build (currently failing due to client modules)  
./gradlew buildPlugin

# Test individual module compilation
./gradlew :plugin:compileJava
./gradlew :client:protocol:rdgen
./gradlew :client:connector:compileKotlin
```

## Notes
- Plugin successfully runs IntelliJ Platform tasks when client modules are disabled
- Main plugin functionality should work for Git-only features
- TFVC features will be unavailable until client modules are fixed
- GitHub Actions workflow updated for Java 21 compatibility

---
**Migration Progress**: 70% Complete  
**Next Priority**: Fix RdGen plugin compatibility or find alternative code generation approach