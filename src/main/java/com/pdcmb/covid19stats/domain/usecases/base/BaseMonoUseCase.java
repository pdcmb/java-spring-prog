package com.pdcmb.covid19stats.domain.usecases.base;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * Abstract class rappresenting base asynchronous Use Case (Interactor)
 * which returns a {@link Mono} 
 * 
 * @author Mateusz Ziomek
 * @param <I> Parameter (input) consumed by Use Case
 * @param <O> Value emitted (output) by the returned stream
 * @see BaseFluxUseCase
 */
public abstract class BaseMonoUseCase<I extends IRequest, O extends IResponse> {

    /**
     * Creates the {@link Mono} used by execute method
     *
     * @param request Parameters passed to and used by use case
     * @return {@link Mono} which emits requested value
     */
    protected abstract Mono<O> createPublisher(I request);

    /**
     * Executes Use Case and returns {@link Mono} which emmitts a value.
     *
     * @param request Parameter to be passed to Use Case
     * @return A Mono that emits requested value
     */
    public Mono<O> execute(I request){
        return createPublisher(request)
                    .subscribeOn(Schedulers.elastic());
    }



}
