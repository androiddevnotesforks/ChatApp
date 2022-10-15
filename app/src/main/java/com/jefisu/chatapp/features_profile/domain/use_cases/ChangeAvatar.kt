package com.jefisu.chatapp.features_profile.domain.use_cases

import com.jefisu.chatapp.core.data.model.User
import com.jefisu.chatapp.core.data.repository.SharedRepository
import com.jefisu.chatapp.core.util.SimpleResource
import com.jefisu.chatapp.core.util.requestCatch
import com.jefisu.chatapp.features_profile.domain.repository.ProfileRepository

class ChangeAvatar(
    private val repository: ProfileRepository,
    private val sharedRepository: SharedRepository
) {
    suspend operator fun invoke(user: User, data: ByteArray): SimpleResource {
        return requestCatch {
            repository.changeAvatar(user, data)
            sharedRepository.getUser(user.username)
        }
    }
}